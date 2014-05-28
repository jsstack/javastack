package com.jsstack.javastack.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.filestorage.FileStorageManager;
import com.jsstack.javastack.filestorage.IFileStorage;
import com.jsstack.javastack.model.Image;
import com.jsstack.javastack.service.ImageService;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("images")
public class ImagesResource {
	private IDao dao = new Dao();
	private ImageService service = new ImageService();

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

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Image upload(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition contentDispositionHeader) {

		return service.handleImage(fileInputStream,
				contentDispositionHeader.getFileName());
	}

	@Path("{id}")
	public ImageResource getImage(@PathParam("id") int imageId) {
		return new ImageResource(imageId);
	}
}
