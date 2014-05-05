package com.jsstack.javastack.utils;

import java.util.Date;
import java.util.UUID;

public class FakeUtil {
	private static long DATE_MIN_VALUE = 0l; // 1970-1-1 0:0:0
	private static long DATE_MAX_VALUE = 4102444800000l; // 2100-1-1 0:0:0

	public static final String guid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	// [0, Long.MAX_VALUE]
	public static final long longValue() {
		return (long) (Math.random() * (Long.MAX_VALUE + 1));
	}

	// [start, end]
	public static final long longValue(long start, long end) {
		return (long) (Math.random() * (end - start + 1)) + start;
	}

	// [0, Integer.MAX_VALUE]
	public static final int intValue() {
		return (int) (Math.random() * (Integer.MAX_VALUE + 1));
	}

	// [start, end]
	public static final long intValue(int start, int end) {
		return (int) (Math.random() * (end - start + 1)) + start;
	}

	public static final Date date() {
		Date date = new Date();
		date.setTime(longValue(DATE_MIN_VALUE, DATE_MAX_VALUE));
		return date;
	}

	public static final Date dateBefore() {
		Date date = new Date();
		long time = date.getTime();
		date.setTime(longValue(DATE_MIN_VALUE, time - 1));
		date.setTime(time);
		return date;
	}

	public static final Date dateFuture() {
		Date date = new Date();
		long time = date.getTime();
		date.setTime(longValue(time + 1, DATE_MAX_VALUE));
		date.setTime(time);
		return date;
	}
}