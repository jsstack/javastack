package com.jsstack.javastack.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FingerPrintGray3x3 implements Serializable {
	private static final long serialVersionUID = -8158136074891417517L;

	private int id;
	private int imageId;
	private int gray1;
	private int gray2;
	private int gray3;
	private int gray4;
	private int gray5;
	private int gray6;
	private int gray7;
	private int gray8;
	private int gray9;

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

	public int getGray5() {
		return gray5;
	}

	public void setGray5(int gray5) {
		this.gray5 = gray5;
	}

	public int getGray6() {
		return gray6;
	}

	public void setGray6(int gray6) {
		this.gray6 = gray6;
	}

	public int getGray7() {
		return gray7;
	}

	public void setGray7(int gray7) {
		this.gray7 = gray7;
	}

	public int getGray8() {
		return gray8;
	}

	public void setGray8(int gray8) {
		this.gray8 = gray8;
	}

	public int getGray9() {
		return gray9;
	}

	public void setGray9(int gray9) {
		this.gray9 = gray9;
	}

}