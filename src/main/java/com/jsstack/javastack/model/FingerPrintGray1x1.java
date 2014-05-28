package com.jsstack.javastack.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FingerPrintGray1x1 implements Serializable {
	private static final long serialVersionUID = 6006794416033635743L;
	private int id;
	private int imageId;
	private int gray1;

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

	public int getGray1() {
		return gray1;
	}

	public void setGray1(int gray1) {
		this.gray1 = gray1;
	}
}
