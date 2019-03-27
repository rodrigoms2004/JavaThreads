package vmsys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Timestamp;

public class WorkerData implements Runnable {

	
	private Socket	clientSocket	= null;
	private String	serverText		= null;
	private String	gps_data		= null;
	
	public WorkerData(Socket clientSocket, String serverText) {
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
			java.util.Date date= new java.util.Date();
			
			output.write(("Connected " + 
						   this.serverText + " - " + 
						   new Timestamp(date.getTime()) + "").getBytes());
			
			gps_data = getStringFromInputStream(input);
			
			output.close();	
			input.close();
			this.saveDataInDB(gps_data);
			System.out.println("Request processed: " + new Timestamp(date.getTime()));
			
			
		} catch(IOException e) {
			// report exception somewhere
			e.printStackTrace();
		}	// end catch

	}	// end run

	// convert InputStream to String
	// http://www.mkyong.com/java/how-to-convert-inputstream-to-string-in-java/
	private static String getStringFromInputStream(InputStream is) {
	 
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}	// end while
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	// end catch
			}	// end if
		}	// end finally
		return sb.toString();
	}	// end getStringFromInputStream
	
	private void saveDataInDB(String GPS_Data) {
		System.out.println("Received :" + GPS_Data);
		
		String[] GPS_data_array = GPS_Data.split(",");
		for (int i = 0; i < GPS_data_array.length; i++)
			System.out.println(GPS_data_array[i]);
		
		synchronized(this) {
			// here I will save information in db
		}	// end synchronized
	}	// end saveDataInDB
}	// end class
