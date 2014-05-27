package com.jsstack.javastack.mq;

import io.iron.ironmq.Client;
import io.iron.ironmq.Message;
import io.iron.ironmq.Queue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.jsstack.javastack.constant.Global;

public class MQ {
	private static final Client CLIENT = new Client(Global.MQ.PROJECT_ID,
			Global.MQ.TOKEN);
	private static Map<String, Queue> QUEUE_CACHE = new HashMap<String, Queue>();

	public static void push(String q, String msg) {
		Queue queue = getQueue(q);
		try {
			queue.push(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Message get(String q) {
		Queue queue = getQueue(q);
		try {
			return queue.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void del(String q, Message msg) {
		Queue queue = getQueue(q);
		try {
			queue.deleteMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Queue getQueue(String q) {
		if (!QUEUE_CACHE.containsKey(q)) {
			QUEUE_CACHE.put(q, CLIENT.queue(q));
		}

		return QUEUE_CACHE.get(q);
	}
}
