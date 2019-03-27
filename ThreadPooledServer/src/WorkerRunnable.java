import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class WorkerRunnable implements Runnable {

	protected Socket clientSocket 	= null;
	protected String serverText		= null;
	
	public WorkerRunnable(Socket clientSocket, String serverText) {
		this.clientSocket = clientSocket;
		this.serverText = serverText;
	}	// end constructor
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream input = clientSocket.getInputStream();
			OutputStream output = clientSocket.getOutputStream();
			long time = System.currentTimeMillis();
			output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " + 
						this.serverText + " - " + time + "").getBytes());
			output.close();
			input.close();
			System.out.println("Request processed: " + time);
		} catch(IOException e) {
			// report exception somewhere
			e.printStackTrace();
		}
	}	// end run
}	// end class
