package com.jsstack.javastack.resource;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jsstack.javastack.Main;
import com.jsstack.javastack.model.Puzzle;

public class PuzzlesResourceTest {

	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		Main.initAll();
		server = Main.startServer();
		Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	@Test
	public void testGet() {
		List<Puzzle> puzzles = target.path("puzzles").request()
				.get(new GenericType<List<Puzzle>>() {
				});
		assertTrue(puzzles.size() == 0);
	}
}
