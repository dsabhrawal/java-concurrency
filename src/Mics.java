
public class Mics {

	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getName());
		
		Thread t = new ThreadExample();
		t.setName("My Thread");
		t.start();
	}
}


class ThreadExample extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}