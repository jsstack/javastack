package com.jsstack.javastack.worker;

import io.iron.ironmq.Message;

import java.util.ArrayList;
import java.util.List;

import com.jsstack.javastack.mq.MQ;

public class WorkerManager {
	private static List<IWorker> WORKERS = new ArrayList<IWorker>();
	private static boolean FOCUS_STOP = false;

	public static void addWorker(IWorker w) {
		WORKERS.add(w);
	}

	public static void stop() {
		FOCUS_STOP = true;
	}

	public static void start() {
		while (!FOCUS_STOP) {
			for (IWorker w : WORKERS) {
				Message m = MQ.get(w.getQueue());
				w.process(m.getBody());
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
