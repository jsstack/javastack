package com.jsstack.javastack.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FingerPrintGray2x2 implements Serializable {
	private static final long serialVersionUID = 5550335228292341344L;

	private int id;
	private int imageId;
	private int gray1;
	private int gray2;
	private int gray3;
	private int gray4;

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

	public int getGray2() {
		return gray2;
	}

	public void setGray2(int gray2) {
		this.gray2 = gray2;
	}

	public int getGray3() {
		return gray3;
	}

	public void setGray3(int gray3) {
		this.gray3 = gray3;
	}

	public int getGray4() {
		return gray4;
	}

	public void setGray4(int gray4) {
		this.gray4 = gray4;
	}

}
