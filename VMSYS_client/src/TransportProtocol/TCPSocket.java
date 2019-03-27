package TransportProtocol;



import DataTransmission.TCPReceiveData;
import DataTransmission.TCPSendData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSocket extends TransportSocket {

	private Socket connection = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;
	
	
	
	private String getConnStatus(Socket conn) {
		
		return (conn.isConnected() ? "Connected" : "Not Connected");
	}	// end getConnStatus()
	
	public TCPSocket(String destinationIP, int destinationPort) {
		super(destinationIP, destinationPort);
		try {
			connection = new Socket(this.getDestinationIP(), 
					                this.getDestinationPort());
			
			System.out.println("Status: " + getConnStatus(connection));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// end try...catch
	}	// end constructor

	public TCPSocket(String destinationIP, int destinationPort,
			            String sourceIP, int sourcePort) {
		super(destinationIP, destinationPort, sourceIP, sourcePort);
		try {
			connection = new Socket(this.getDestinationIP(), 
					                this.getDestinationPort(),
					                InetAddress.getByName(this.getSourceIP()),
					                this.getSourcePort());
			
			System.out.println("Status: " + getConnStatus(connection));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end try...catch
	}	// end constructor
	
	
	public void sendDataThread(String data_str) {
		TCPSendData sd = new TCPSendData(connection, data_str);
		new Thread(sd).start();
	}
	
	
	public void receiveData() {
		
		try {
			TCPReceiveData trd = new TCPReceiveData(connection);	
			new Thread(trd).start();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
			
	}	// end receiveData()
	
	public void disconnectSocket() {
		try {
			//out.close();
			//in.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	// end disconnectSocket()
	
	
}	// end TCPSocket
