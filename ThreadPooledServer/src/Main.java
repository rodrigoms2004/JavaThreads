
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPooledServer server = new ThreadPooledServer(9000);
		new Thread(server).start();

		try {
		    Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("Stopping Server");
		server.stop();
	}	// end main

}	// end class
