
public class Main {

	public static void main(String[] args) {

		Thread t = new Unit();
		Thread t1 = new Thread(new Unit2());
		t.start();
		
		t1.start();
	}

}
