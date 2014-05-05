package com.jsstack.javastack.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Puzzle implements Serializable {
	private static final long serialVersionUID = 4482006020726400133L;

	private int id;
	private int imageId;
	private long dateCreated;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public long getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(long dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

}
