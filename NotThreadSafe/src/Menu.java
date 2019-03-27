
public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotThreadSafe sharedInstance = new NotThreadSafe();
		System.out.println("Before thread: " + sharedInstance.getBuilder());
		
		new Thread(new MyRunnable(sharedInstance)).start();
		System.out.println("After first thread: " + sharedInstance.getBuilder());
		
		new Thread(new MyRunnable(sharedInstance)).start();
		System.out.println("After second thread: " + sharedInstance.getBuilder());
		
		new Thread(new MyRunnable(new NotThreadSafe())).start();
		new Thread(new MyRunnable(new NotThreadSafe())).start();
		
	}	// end main

}	// end class
