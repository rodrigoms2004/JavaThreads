public class Menu {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);
		Thread threadC = new CounterThread(counter);
		Thread threadD = new CounterThread(counter);
		
		System.out.println("Before first thread, count: " + counter.getCount());
		threadA.start();
		System.out.println("After thread A, count: " + counter.getCount());
		threadB.start();
		System.out.println("After thread B, count: " + counter.getCount());
		
		Thread.sleep(500);
		System.out.println("After half second, count: " + counter.getCount());
	}	// end main()

}	// end class
