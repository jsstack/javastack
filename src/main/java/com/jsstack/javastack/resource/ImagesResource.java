package com.jsstack.javastack.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.model.Image;

@Path("images")
public class ImagesResource {
	private IDao dao = new Dao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Image> getImages() {
		return dao.findAll(Image.class);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Image addImage(Image image) {
		image.setId(-1);
		image.setId(dao.insert(image));
		return image;
	}

	@Path("{id}")
	public ImageResource getImage(@PathParam("id") int imageId) {
		return new ImageResource(imageId);
	}
}
