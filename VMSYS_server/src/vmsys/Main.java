package vmsys;



public class Main {
	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ThreadPoolServer server = new ThreadPoolServer(5005);
		new Thread(server).start();

		try {
		    Thread.sleep(200 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("Stopping Server");
		server.stop();
		
	}	// end main

}	// end class
