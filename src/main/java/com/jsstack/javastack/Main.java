package com.jsstack.javastack;

import java.io.IOException;
import java.net.URI;

import org.flywaydb.core.Flyway;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.jsstack.javastack.dao.DBHelper;
import com.jsstack.javastack.worker.WorkerManager;

/**
 * Main class.
 * 
 */
public class Main {
	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8080/webapi/";
	private static boolean inited = false;

	public static void initAll() {
		if (inited) {
			return;
		}
		
		inited = true;
		
		System.setProperty("mysql-host", "127.0.0.1");
		System.setProperty("mysql-port", "3306");
		System.setProperty("mysql-db", "javastack");
		System.setProperty("mysql-username", "root");
		System.setProperty("mysql-password", "jsstack");
		System.setProperty("fs", "disk");
		System.setProperty("dfs-base", "C:\\FileStorage\\");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out
				.println("=============================================Migrating...");
		Flyway flyway = new Flyway();
		flyway.setDataSource(DBHelper.getDataSource());

		flyway.migrate();
		
		
		WorkerManager.start();
	}

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and
		// providers
		// in com.example package
		final ResourceConfig rc = new ResourceConfig()
				.packages("com.jsstack.javastack");

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),
				rc);
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
		System.out.println(String.format(
				"Jersey app started with WADL available at "
						+ "%sapplication.wadl\nHit enter to stop it...",
				BASE_URI));
		System.in.read();
		server.stop();
	}
}
