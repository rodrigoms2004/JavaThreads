
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// using a Thread subclass...
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println(myThread.getName());
		
		// and with an anonymous class too
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("2 - Subclass inner Thread Running by: " + getName());
			}	// end run
		};	// end inner class
		thread1.start();
		System.out.println(thread1.getName());
		
		/***************************************************/
		// using Interface implemention
		Thread thread2 = new Thread(new MyRunnable());
		thread2.start();
		System.out.println(thread2.getName());
		
		// and with an anonymous class too
		Runnable myRunnable = new Runnable() {
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println(" 4 - inner class Runnable running by: " + threadName);
			}	// end run()
		};	// end inner class
		Thread thread3 = new Thread(myRunnable, "New Thread");
		thread3.start();
		System.out.println(thread3.getName());
		
		System.out.println("***********************");
		
		// Multiple Threads
		new MultipleThreads();
		
		
	}	// end main
}	// end class main
