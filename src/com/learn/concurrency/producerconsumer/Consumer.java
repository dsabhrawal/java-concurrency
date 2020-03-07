package com.learn.concurrency.producerconsumer;

import java.util.List;

public class Consumer implements Runnable {

	private final List<Integer> taskList;
	private final int MAX_CAPACITY;
	
	public Consumer(List<Integer> taskList, int maxItems) {
		this.taskList = taskList;
		this.MAX_CAPACITY = maxItems;
	}
	@Override
	public void run() {

		int counter = 0;
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void consume() throws InterruptedException {
		synchronized (taskList) {
			while(taskList.isEmpty()) {
				System.out.println("Queue is empty " + Thread.currentThread().getName()+ " is waiting, size: "+taskList.size());
				taskList.wait();
			}
			Thread.sleep(1000);
			int i = taskList.remove(0);
			System.out.println("Consumed: "+ i);
			taskList.notifyAll();
			
		}
	}

}
