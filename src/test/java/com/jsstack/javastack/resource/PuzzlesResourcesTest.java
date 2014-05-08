package com.jsstack.javastack.resource;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jsstack.javastack.Main;
import com.jsstack.javastack.model.Puzzle;

public class PuzzlesResourcesTest {

	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		Main.initAll();
		server = Main.startServer();
		Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
	}

	@SuppressWarnings("deprecation")
	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	@Test
	public void testPuzzles() throws IOException {
		List<Puzzle> puzzles = target.path("puzzles").request()
				.get(new GenericType<List<Puzzle>>() {
				});

		int countFirst = puzzles.size();
		Puzzle p = new Puzzle();
		p.setImageId(1);

		Puzzle insertPuzzle = target
				.path("puzzles")
				.request()
				.post(Entity.entity(p, MediaType.APPLICATION_JSON),
						Puzzle.class);

		assertTrue(insertPuzzle.getId() > 0);
		assertTrue(insertPuzzle.getImageId() == 1);

		puzzles = target.path("puzzles").request()
				.get(new GenericType<List<Puzzle>>() {
				});
		int countInsert = puzzles.size();
		assertTrue(countInsert - countFirst == 1);

		Puzzle queryPuzzle = target.path("puzzles/" + insertPuzzle.getId())
				.request().get(Puzzle.class);
		assertTrue(queryPuzzle.getImageId() == insertPuzzle.getImageId());

		Response resp = target.path("puzzles/" + insertPuzzle.getId())
				.request().delete();

		assertTrue(resp.getStatus() == 204);
	}

	private void printResponse(Response resp) throws IOException {
		System.out.println(resp.getStatus());
		for (String str : IOUtils.readLines((InputStream) resp.getEntity())) {
			System.out.println(str);
		}
	}
}
