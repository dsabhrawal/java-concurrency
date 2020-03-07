package com.learn.concurrency.producerconsumer;

import java.util.List;

public class Producer implements Runnable {

	private final List<Integer> taskList;
	private final int MAX_CAPACITY;
	
	public Producer(List<Integer> taskList, int maxItems) {
		this.taskList = taskList;
		this.MAX_CAPACITY = maxItems;
	}
	@Override
	public void run() {

		int counter = 0;
		while(true) {
			try {
				produce(counter++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void produce(int i) throws InterruptedException {
		synchronized (taskList) {
			while(taskList.size() == MAX_CAPACITY) {
				System.out.println("Queue is full" + Thread.currentThread().getName()+ " is waiting, size: "+taskList.size());
				taskList.wait();
			}
			Thread.sleep(1000);
			taskList.add(i);
			System.out.println("Produced: "+ i);
			taskList.notifyAll();
			
		}
	}

}
