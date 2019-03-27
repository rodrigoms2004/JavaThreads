public class CounterThread extends Thread {
	
	protected Counter counter = null;
	
	public CounterThread(Counter counter) {
		this.counter = counter;
	}	// end constructor
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			counter.add(i);
		}	// end for
	}	// end run()
}	// end class
