package com.learn.concurrency;

public class RunnableWithLambdaExample {

	public static void main(String[] args) {

		Runnable  r = () -> System.out.println("This is thread 1");
		Thread t = new Thread(r);
		t.start();
		new Thread(() -> System.out.println("This is thread 2")).start();
	}

}
