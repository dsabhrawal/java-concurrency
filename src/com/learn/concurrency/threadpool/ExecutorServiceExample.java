package com.learn.concurrency.threadpool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	private static final int THREADS = 10;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(THREADS);
		for (int i = 0; i < 500; i++) {
			Runnable task = new Task(100000 + i);
			executor.execute(task);
		}
		executor.shutdown();

	}

}
