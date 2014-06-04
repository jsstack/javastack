package com.jsstack.javastack.filestorage;

import java.io.IOException;
import java.io.InputStream;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.Bucket;
import com.aliyun.openservices.oss.model.OSSObject;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.jsstack.javastack.constant.Global;

public class AliyunStorage implements IFileStorage {
	private OSSClient client;

	private synchronized OSSClient getClient() {
		if (client == null) {
			client = new OSSClient(Global.AliyunStorage.ACCESS_KEY_ID,
					Global.AliyunStorage.ACCESS_KEY_SECRET);
			boolean find = false;
			for (Bucket b : client.listBuckets()) {
				if (Global.AliyunStorage.BUCKET_NAME.equals(b.getName())) {
					find = true;
				}
			}

			if (!find) {
				client.createBucket(Global.AliyunStorage.BUCKET_NAME);
			}
		}

		return client;
	}

	@Override
	public void write(String fileFullName, InputStream content)
			throws IOException {
		ObjectMetadata meta = new ObjectMetadata();
		meta.setContentLength(content.available());
		getClient().putObject(Global.AliyunStorage.BUCKET_NAME,
				Global.AliyunStorage.OBJECT_NAME_PREFIX + fileFullName,
				content, meta);
	}

	@Override
	public InputStream read(String fileFullName) throws IOException {
		OSSObject obj = getClient().getObject(Global.AliyunStorage.BUCKET_NAME,
				Global.AliyunStorage.OBJECT_NAME_PREFIX + fileFullName);
		return obj.getObjectContent();
	}

}
