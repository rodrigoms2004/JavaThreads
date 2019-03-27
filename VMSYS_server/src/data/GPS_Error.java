package data;

public class GPS_Error {

	// GPRS erros
	private boolean isSIMconnected;
	private boolean isModuleRegistered;
	private boolean isRSSIlow;
	private boolean isAttached;
	private boolean isPDPactive;
	
	// GPS errors
	private int gps_error_id;
	
	// Energy and battery errors
	private boolean isConnectedInMainPowerSupply;
	private boolean isBatteryChargeLow;
	private boolean isBatteryTemperatureHigh;
	
	// chassis intrusion alarm
	private boolean isChassisOpened;
	private boolean isChassisDesconnectedFromMachine;
	
	public GPS_Error(boolean isSIMconnected, 
					 boolean isModuleRegistered,
					 boolean isRSSIlow, 
					 boolean isAttached, 
					 boolean isPDPactive,
					 int gps_error_id, 
					 boolean isConnectedInMainPowerSupply,
					 boolean isBatteryChargeLow, 
					 boolean isBatteryTemperatureHigh,
					 boolean isChassisOpened, 
					 boolean isChassisDesconnectedFromMachine) {
		super();
		this.isSIMconnected = isSIMconnected;
		this.isModuleRegistered = isModuleRegistered;
		this.isRSSIlow = isRSSIlow;
		this.isAttached = isAttached;
		this.isPDPactive = isPDPactive;
		this.gps_error_id = gps_error_id;
		this.isConnectedInMainPowerSupply = isConnectedInMainPowerSupply;
		this.isBatteryChargeLow = isBatteryChargeLow;
		this.isBatteryTemperatureHigh = isBatteryTemperatureHigh;
		this.isChassisOpened = isChassisOpened;
		this.isChassisDesconnectedFromMachine = isChassisDesconnectedFromMachine;
	}	// end constructor
}	// end class
