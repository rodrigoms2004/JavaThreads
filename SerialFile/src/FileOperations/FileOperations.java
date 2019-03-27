package FileOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Data.GPS_Data;

public class FileOperations {
	
	private GPS_Data gps_Data = null;
	private String filePathAndName = null;
	private FileOutputStream fileOut = null;
	private FileInputStream fileIn = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	
	
	public FileOperations(GPS_Data gps_Data, String filePathAndName) {
		this.gps_Data = gps_Data;
		this.filePathAndName = filePathAndName;
	}	// end constructor
	
	public FileOperations(String filePathAndName) {
		this.filePathAndName = filePathAndName;
	}	// end constructor
	
	
	public Boolean objectToFile() {
		try {
			fileOut = new FileOutputStream(this.filePathAndName);
			out = new ObjectOutputStream(this.fileOut);
			out.writeObject(this.gps_Data);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}	// end catch
		
		return true;
	}	// end objectToFile
	
	
	public GPS_Data fileToObject() {
		try {
			fileIn = new FileInputStream(this.filePathAndName);
			in = new ObjectInputStream(fileIn);
			gps_Data = (GPS_Data) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gps_Data;
	}	// end fileToObject
	
}	// end class

