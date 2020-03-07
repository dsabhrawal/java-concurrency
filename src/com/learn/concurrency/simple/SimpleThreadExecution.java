package com.learn.concurrency.simple;


public class SimpleThreadExecution {

	public static void main(String[] args) {

		Thread t = new ExtendedThread();
		Thread t1 = new Thread(new RunnableThread());
		t.start();
		t1.start();
	}

}
