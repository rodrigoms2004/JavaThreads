import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MultiThreadedServer implements Runnable{

	protected int			serverPort		= 8080;
	protected ServerSocket 	serverSocket	= null;
	protected boolean		isStopped		= false;
	protected Thread		runningThread	= null;
	
	public MultiThreadedServer(int port) {
		this.serverPort = port;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this) {
			this.runningThread = Thread.currentThread();
		}
		openServerSocket();
		
		while(! isStopped()) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if(isStopped()) {
					System.out.println("Server Stopped");
					return;
				}	// end if
				throw new RuntimeException(
						"Error accepting client connection", e);
			}
			 new Thread(
		                new WorkerRunnable(
		                    clientSocket, "Multithreaded Server")).start();
		}	// end while
		System.out.println("Server Stopped.");
	}	// end run()

	
	public synchronized boolean isStopped() {
		return this.isStopped;
	}
	
	public synchronized void stop() {
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}	// end stop
	
	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			throw new RuntimeException("Cannot open port " + String.valueOf(this.serverPort), e);
		}
	}	// end openServerSocket
	
}	// end class

