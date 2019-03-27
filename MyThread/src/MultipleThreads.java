
public class MultipleThreads {

	public MultipleThreads(){
		
		System.out.println(Thread.currentThread().getName());
		for(int i = 0 ; i < 10; i++) {
			
			new Thread("" + i) {
			
				public void run() {
					System.out.println("Thread: " + getName() + " running");
				}	// end run()
				
			}.start();	// end inner object
			
		}	// end for
	}	// end MultipleThreads
}	//end class
