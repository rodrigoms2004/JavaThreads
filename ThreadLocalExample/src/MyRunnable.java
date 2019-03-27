
public class MyRunnable implements Runnable {
	 
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		threadLocal.set((int) (Math.random() * 100D));
		int threadLocalValue = threadLocal.get();
		
		
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println(e.toString());
		}	// end catch
		
		System.out.println(threadLocal.get());
	}	// end run()
}	// end class
