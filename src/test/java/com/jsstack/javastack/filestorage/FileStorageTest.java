package com.jsstack.javastack.filestorage;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class FileStorageTest {

	@Test
	public void test() throws IOException {
		AliyunStorage as = new AliyunStorage();
		ByteArrayInputStream bais = new ByteArrayInputStream(
				"abcdefg".getBytes());
		as.write("this/is/a/test/a.png", bais);

		InputStream in = as.read("this/is/a/test/a.png");

		byte[] b = new byte[7];
		in.read(b);

		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		System.out.println(b[3]);
		System.out.println(b[4]);
		System.out.println(b[5]);
		System.out.println(b[6]);
		assertTrue(b[0] == 'a');
		assertTrue(b[1] == 'b');
		assertTrue(b[2] == 'c');
		assertTrue(b[3] == 'd');
		assertTrue(b[4] == 'e');
		assertTrue(b[5] == 'f');
		assertTrue(b[6] == 'g');

	}
}
