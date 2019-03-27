package DataTransmission;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPReceiveData implements Runnable {
	
	private Socket conn = null;
	private DataInputStream in = null;
	private SocketAddress socketAddress = null;
	
	public TCPReceiveData(Socket conn) {
		this.conn = conn;
	}	// end constructor

	@Override
	public void run() {
		
		try {
			in = new DataInputStream(conn.getInputStream());
			socketAddress = conn.getRemoteSocketAddress();
			
			System.out.println("Received " + in.readLine() + 
					" from " + socketAddress.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
		
	}	// end run()
}
