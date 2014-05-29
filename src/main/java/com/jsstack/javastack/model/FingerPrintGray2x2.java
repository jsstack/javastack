package com.jsstack.javastack.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FingerPrintGray2x2 implements Serializable {
	private static final long serialVersionUID = 5550335228292341344L;

	private int id;
	private int imageId;
	private float v1;
	private float v2;
	private float v3;
	private float v4;

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

	public float getV2() {
		return v2;
	}

	public void setV2(float v2) {
		this.v2 = v2;
	}

	public float getV3() {
		return v3;
	}

	public void setV3(float v3) {
		this.v3 = v3;
	}

	public float getV4() {
		return v4;
	}

	public void setV4(float v4) {
		this.v4 = v4;
	}
}
