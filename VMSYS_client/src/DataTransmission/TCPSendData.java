package DataTransmission;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPSendData implements Runnable {

	private Socket conn = null;
	private String dataStr;
	private DataOutputStream out = null;
	
	public TCPSendData(Socket conn, String dataStr) {
		this.conn = conn;
		this.dataStr = dataStr;
	}	// end constructor
	
	@Override
	public void run() {
	
		try {
			out = new DataOutputStream(conn.getOutputStream());
			out.writeBytes(this.dataStr);
			out.flush();
			System.out.println("Sent " + this.dataStr);
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// end run()

}	// end class

