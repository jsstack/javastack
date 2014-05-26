package com.jsstack.javastack.resource;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jsstack.javastack.Main;
import com.jsstack.javastack.model.Image;

public class ImagesResourcesTest {

	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() {
		Main.initAll();
		server = Main.startServer();
		Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
	}

	@After
	public void tearDown() {
		server.stop();
	}

	@Test
	public void testImages() {
		List<Image> imagesStart = target.path("images").request()
				.get(new GenericType<List<Image>>() {
				});
		int countStart = imagesStart.size();

		Image image = new Image();
		image.setImagePath("imagePath");
		image.setThumbnailPath("thumbnailPath");

		Image img = target
				.path("images")
				.request()
				.post(Entity.entity(image, MediaType.APPLICATION_JSON),
						Image.class);

		assertTrue(img.getId() > 0);
		assertTrue(image.getImagePath().equals(img.getImagePath()));
		assertTrue(image.getThumbnailPath().equals(img.getThumbnailPath()));

		List<Image> imagesAfterInsert = target.path("images").request()
				.get(new GenericType<List<Image>>() {
				});
		int countAfterInsert = imagesAfterInsert.size();

		assertTrue(countAfterInsert - countStart == 1);

		Image qimg = target.path("images/" + img.getId()).request()
				.get(Image.class);

		assertTrue(qimg.getImagePath().equals(img.getImagePath()));
		assertTrue(qimg.getThumbnailPath().equals(img.getThumbnailPath()));

		Response r = target.path("images/" + img.getId()).request().delete();
		assertTrue(r.getStatus() == 204);

		List<Image> imagesAfterDelete = target.path("images").request()
				.get(new GenericType<List<Image>>() {
				});
		int countAfterDelete = imagesAfterDelete.size();

		assertTrue(countAfterDelete == countStart);
	}
}
