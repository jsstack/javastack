package com.jsstack.javastack.filestorage;

public class FileStorageManager {
	public static IFileStorage get() {
		String fsSetting = System.getProperty("fs");
		if (fsSetting.equals("disk")) {
			String basePath = System.getProperty("dfs-base");
			return new DiskFileStorage(basePath);
		} else {
			return new AliyunStorage();
		}
	}
}
