package Data;

import java.io.Serializable;

public class GPS_Data implements Serializable {

	// GPS coordinates
	private String 	latitude;
	private String  longitude;
	
	public GPS_Data(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}	// end constructor
	
	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	
}	// end class
