
public class ThreadLocalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable sharedRunnableInstance = new MyRunnable();
		
		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);
		
		thread1.start();
		thread2.start();
	}	// end main

}	// end class
