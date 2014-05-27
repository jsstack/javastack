package com.jsstack.javastack.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.jsstack.javastack.Main;
import com.jsstack.javastack.model.Image;
import com.jsstack.javastack.utils.FakeUtil;

public class DaoTest {
	private static IDao dao;

	
	//@Before
	public void init() {
		Main.initAll();
		dao = new Dao();
	}

	//@After
	public void destory() {
	}

	//@Test
	public void daoTest() {
		Image s = new Image();
		s.setImagePath(FakeUtil.guid());
		s.setThumbnailPath(FakeUtil.guid());
		int id = dao.insert(s);
		s.setId(id);

		List<Image> result = dao.findAll(Image.class, null);
		assertTrue(result.size() > 0);
		System.out.println("abc");
		Image n = dao.findById(Image.class, id);
		assertTrue(n != null);
		System.out.println(n.getId());
		System.out.println(s.getImagePath());
		System.out.println(s.getThumbnailPath());
		assertTrue(n.getId() == s.getId());
		assertTrue(n.getImagePath().equals(s.getImagePath()));
		assertTrue(n.getThumbnailPath().equals(s.getThumbnailPath()));

		n.setImagePath(FakeUtil.guid());
		
		dao.update(n);
		assertTrue(n.getId() == s.getId());
		assertTrue(!n.getImagePath().equals(s.getImagePath()));

		dao.delete(Image.class, id);

		List<Image> nr = dao.findAll(Image.class, null);
		assertTrue(result.size() == nr.size() + 1);
	}
}

