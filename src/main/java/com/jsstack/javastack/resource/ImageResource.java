package com.jsstack.javastack.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.model.Image;

public class ImageResource {

	private IDao dao = new Dao();
	private int imageId;

	public ImageResource(int imageId) {
		this.imageId = imageId;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Image getImage() {
		return dao.findById(Image.class, imageId);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Image updateImage() {
		throw new UnsupportedOperationException();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteImage() {
		if (dao.delete(Image.class, imageId) <= 0) {
			throw new NotFoundException("No such Image.");
		}
	}
}
