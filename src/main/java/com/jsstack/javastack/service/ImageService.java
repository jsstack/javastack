package com.jsstack.javastack.service;

import java.io.IOException;
import java.io.InputStream;

import com.jsstack.javastack.constant.Global;
import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.filestorage.FileStorageManager;
import com.jsstack.javastack.filestorage.IFileStorage;
import com.jsstack.javastack.model.Image;
import com.jsstack.javastack.mq.MQ;

public class ImageService {
	private IDao dao = new Dao();

	public Image handleImage(InputStream fileInputStream, String fileName) {
		IFileStorage fs = FileStorageManager.get();
		fileName = getFileName(fileName);
		boolean successfull = false;
		try {
			fs.write(fileName, fileInputStream);
			successfull = true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!successfull) {
			return null;
		}

		Image img = new Image();
		img.setImagePath(fileName);

		int id = dao.insert(img);
		img.setId(id);

		MQ.push(Global.ImageService.PARSE_IMAGE_MQ, String.valueOf(id));

		return img;
	}

	private String generateThumbnail(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getFileName(String fileName) {
		return fileName;
	}

}
