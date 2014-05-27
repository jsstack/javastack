package com.jsstack.javastack.filestorage;

import java.io.IOException;
import java.io.InputStream;

public interface IFileStorage {
	void write(String fileFullName, InputStream content) throws IOException;

	InputStream read(String fileFullName) throws IOException;
}
