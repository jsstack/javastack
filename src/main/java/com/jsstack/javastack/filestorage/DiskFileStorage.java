package com.jsstack.javastack.filestorage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class DiskFileStorage implements IFileStorage {
	private String basePath = "";

	public DiskFileStorage(String basePath) {
		this.basePath = basePath;
	}

	@Override
	public void write(String fileFullName, InputStream content) throws IOException {
		FileUtils.copyInputStreamToFile(content, new File(basePath + fileFullName));
	}

	@Override
	public InputStream read(String fileFullName) throws IOException {
		return FileUtils.openInputStream(new File(basePath + fileFullName));
	}

}
