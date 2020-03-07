package com.learn.concurrency.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerMain {

	public static void main(String[] args) {

		List<Integer> taskList = new ArrayList<>();
		int MAX_CAPACITY = 5;
		Thread tProducer = new Thread(new Producer(taskList, MAX_CAPACITY), "Producer");
		Thread tConsumer = new Thread(new Consumer(taskList, MAX_CAPACITY), "Consumer");
		tProducer.start();
		tConsumer.start();
		
	}

}
