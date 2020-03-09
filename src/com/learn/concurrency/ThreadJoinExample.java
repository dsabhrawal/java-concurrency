package com.learn.concurrency;

public class ThreadJoinExample {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+ " "+i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}, "Thread 1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+ " "+i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
			
		}, "Thread 2");
		//t1.setPriority(10);
		//t2.setPriority(1);
		t1.start();
		t1.join(); //T2 will start execution after completion of T1
		Thread.yield();
		t2.start();	
	}
}
