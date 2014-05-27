package com.jsstack.javastack.worker;

public interface IWorker {

	String getQueue();

	void process(String msg);

}
