package com.jsstack.javastack.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FingerPrint2x2 implements Serializable {
	private static final long serialVersionUID = 886702125835771622L;

	private int id;
	private int imageId;
	private float h1;
	private float s1;
	private float v1;
	private float h2;
	private float s2;
	private float v2;
	private float h3;
	private float s3;
	private float v3;
	private float h4;
	private float s4;
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

	public float getH1() {
		return h1;
	}

	public void setH1(float h1) {
		this.h1 = h1;
	}

	public float getS1() {
		return s1;
	}

	public void setS1(float s1) {
		this.s1 = s1;
	}

	public float getV1() {
		return v1;
	}

	public void setV1(float v1) {
		this.v1 = v1;
	}

	public float getH2() {
		return h2;
	}

	public void setH2(float h2) {
		this.h2 = h2;
	}

	public float getS2() {
		return s2;
	}

	public void setS2(float s2) {
		this.s2 = s2;
	}

	public float getV2() {
		return v2;
	}

	public void setV2(float v2) {
		this.v2 = v2;
	}

	public float getH3() {
		return h3;
	}

	public void setH3(float h3) {
		this.h3 = h3;
	}

	public float getS3() {
		return s3;
	}

	public void setS3(float s3) {
		this.s3 = s3;
	}

	public float getV3() {
		return v3;
	}

	public void setV3(float v3) {
		this.v3 = v3;
	}

	public float getH4() {
		return h4;
	}

	public void setH4(float h4) {
		this.h4 = h4;
	}

	public float getS4() {
		return s4;
	}

	public void setS4(float s4) {
		this.s4 = s4;
	}

	public float getV4() {
		return v4;
	}

	public void setV4(float v4) {
		this.v4 = v4;
	}

}
