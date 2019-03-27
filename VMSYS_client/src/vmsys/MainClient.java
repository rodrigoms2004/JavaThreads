package vmsys;

import TransportProtocol.TCPSocket;

public class MainClient {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//String ip = "localhost";
		String ip = "54.232.230.116";
		int port = 5005;
		//String dataGPS = "49.549,54.223,22,10,2300,1234567890,10";
		String dataGPS = "49.549,54.223,10";
		TCPSocket client = new TCPSocket(ip, port);
		
		Thread.sleep(1000);
		client.receiveData();
		Thread.sleep(1000);
		client.sendDataThread(dataGPS);
		Thread.sleep(1000);
		client.disconnectSocket();
		
	}	// end main

}	// end class
