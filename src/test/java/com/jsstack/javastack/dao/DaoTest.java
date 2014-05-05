package com.jsstack.javastack.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jsstack.javastack.Main;
import com.jsstack.javastack.utils.FakeUtil;

public class DaoTest {
	private static IDao dao;

	@Before
	public void init() {
		Main.initAll();
		dao = new Dao();
	}

	@After
	public void destory() {

	}

	@Test
	public void daoTest() {
		Story s = new Story();
		s.setDateCreated(FakeUtil.date().getTime());
		s.setContent(FakeUtil.guid());
		int id = dao.insert(s);

		List<Story> result = dao.findAll(Story.class, null);
		assertTrue(result.size() > 0);
		System.out.println("abc");
		Story n = dao.findById(Story.class, id);
		assertTrue(n != null);
		System.out.println(n.getDateCreated());
		System.out.println(s.getDateCreated());
		assertTrue(n.getDateCreated() == s.getDateCreated());
		assertTrue(n.getContent().equals(s.getContent()));
		n.setContent(FakeUtil.guid());

		System.out.println("123");
		dao.update(n);
		assertTrue(n.getDateCreated() == s.getDateCreated());
		assertTrue(!n.getContent().equals(s.getContent()));

		dao.delete(Story.class, id);

		List<Story> nr = dao.findAll(Story.class, null);
		assertTrue(result.size() == nr.size() + 1);
	}
}
