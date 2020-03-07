package com.learn.concurrency.threadpool;
import java.util.ArrayList;
import java.util.List;

public class ThreadPoolExample {

	public static void main(String[] args) {

		List<Thread> threads = new ArrayList<Thread>();
		for(int i=0; i<500;i++) {
			Runnable task = new Task(100000L+i);
			Thread thread = new Thread(task);
			thread.setName(String.valueOf(i));
			thread.start();
			threads.add(thread);
		}
	}

}
