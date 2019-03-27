package Main;

import Data.GPS_Data;
import FileOperations.FileOperations;

public class Main {
	
	// Sorocaba Latitude/Longitude = -23.501403 / -47.457917
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creates an object with Sorocaba's coordinates
		GPS_Data gps_Data = new GPS_Data("-23.501403", "-47.457917");
		String filename = "/tmp/gps_data.obj";
		FileOperations fo = null;
		
		
		/* copy an object GPS_Data into a file */
		fo = new FileOperations(gps_Data, filename);
		if( fo.objectToFile() ) {
			System.out.println("GPS data saved in " + filename);
		} else {
			System.out.println("GPS data save fail");
		}	// end else
		
		
		/* Restore an object GPS_Data from an file */
		fo = new FileOperations(filename);
		GPS_Data new_GPS_Data = fo.fileToObject();
		System.out.println("Latitude/ Logintude: " 
								+ new_GPS_Data.getLatitude() 
								+ "/"
								+ new_GPS_Data.getLongitude());
	}	// end main

}	// end class
