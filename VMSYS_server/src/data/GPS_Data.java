package data;

public class GPS_Data {

	// GPS coordinates
	private String 	latitude;
	private String  longitude;
	
	// RSSI, signal strength
	private int RSSI;
	
	// Battery status
	private int temperature;
	private int eletricCharge; 
	
	// Identification
	private long IMEI;
	private long id;
	
	public GPS_Data(String latitude, 
					String longitude, 
					int rSSI,
					int temperature, 
					int eletricCharge, 
					long iMEI, 
					long id) {
		// 49.549,54.223,22,10,2300,1234567890,10
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		RSSI = rSSI;
		this.temperature = temperature;
		this.eletricCharge = eletricCharge;
		IMEI = iMEI;
		this.id = id;
	}	// end constructor
}	// end class
