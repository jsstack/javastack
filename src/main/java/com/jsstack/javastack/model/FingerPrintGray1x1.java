package com.jsstack.javastack.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FingerPrintGray1x1 implements Serializable {
	private static final long serialVersionUID = 6006794416033635743L;
	private int id;
	private int imageId;
	private float v1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public float getV1() {
		return v1;
	}

	public void setV1(float v1) {
		this.v1 = v1;
	}

}
