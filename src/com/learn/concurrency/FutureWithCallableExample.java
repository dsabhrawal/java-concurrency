package com.learn.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureWithCallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Callable<Integer> c = () -> {

			Thread.sleep(5000);
			return 3 * 2;
		};
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(c);

		if (!future.isDone()) {
			System.out.println("Under process...");
		}

		System.out.println("Task is completed with result: " + future.get());
		es.shutdown();
	}

}
