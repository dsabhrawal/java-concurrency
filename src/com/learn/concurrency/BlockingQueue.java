package com.learn.concurrency;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	private List queue = new LinkedList();
	private int limit  = 10;
	public BlockingQueue(int limit) {
		this.limit = limit;
	}
	public synchronized void putObject(Object object) throws InterruptedException {
		while(queue.size() == limit) {
			wait();
		}
		if(queue.size() == 0) {
			notifyAll();
		}
		queue.add(object);
	}
	
	public synchronized Object getObject() throws InterruptedException {
		while(queue.size() == 0) {
			wait();
		}
		if(queue.size() == limit) {
			notifyAll();
		}
		return queue.remove(0);
	}
}
