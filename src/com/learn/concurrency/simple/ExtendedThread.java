package com.learn.concurrency.simple;

public class ExtendedThread extends Thread{

	public void run() {
		System.out.println(this.getName() + " is running.");
	}
}
