
public class Main {

	// access using http://localhost:9000/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleThreadedServer server = new SingleThreadedServer(9000);
		new Thread(server).start();
		
		try {
			Thread.sleep(100 * 1000);
		}	catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Stopping Server");
		server.stop();
	}	// end main

}	// end class
