package com.jsstack.javastack.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FingerPrintGray3x3 implements Serializable {
	private static final long serialVersionUID = -8158136074891417517L;

	private int id;
	private int imageId;
	private float v1;
	private float v2;
	private float v3;
	private float v4;
	private float v5;
	private float v6;
	private float v7;
	private float v8;
	private float v9;

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

	public float getV5() {
		return v5;
	}

	public void setV5(float v5) {
		this.v5 = v5;
	}

	public float getV6() {
		return v6;
	}

	public void setV6(float v6) {
		this.v6 = v6;
	}

	public float getV7() {
		return v7;
	}

	public void setV7(float v7) {
		this.v7 = v7;
	}

	public float getV8() {
		return v8;
	}

	public void setV8(float v8) {
		this.v8 = v8;
	}

	public float getV9() {
		return v9;
	}

	public void setV9(float v9) {
		this.v9 = v9;
	}

}
