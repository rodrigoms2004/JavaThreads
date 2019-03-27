import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPooledServer implements Runnable {
	protected int			serverPort		= 8080;
	protected ServerSocket 	serverSocket	= null;
	protected boolean		isStopped		= false;
	protected Thread		runningThread	= null;
    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);
            
	public ThreadPooledServer(int port) {
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
			 
		    this.threadPool.execute(
		             new WorkerRunnable(clientSocket, "Thread Pooled Server"));
		    
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
	