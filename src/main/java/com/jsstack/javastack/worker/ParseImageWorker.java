package com.jsstack.javastack.worker;

import com.jsstack.javastack.constant.Global;
import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.model.Image;

public class ParseImageWorker implements IWorker {

	private IDao dao = new Dao();

	@Override
	public String getQueue() {
		return Global.ImageService.PARSE_IMAGE_MQ;
	}

	@Override
	public void process(String msg) {
		int id = Integer.parseInt(msg);
		Image img = dao.findById(Image.class, id);
		String thumbnailPath = generateThumbnail(img.getImagePath());
		img.setThumbnailPath(thumbnailPath);
		
		dao.insert(img);
		
		generateFingerPrints(img);
	}

	private void generateFingerPrints(Image img) {
		// TODO Auto-generated method stub
		
	}

	private String generateThumbnail(String imagePath) {
		// TODO Auto-generated method stub
		return null;
	}

}

