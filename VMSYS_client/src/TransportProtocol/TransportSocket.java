package TransportProtocol;

public class TransportSocket {

	private int sourcePort;
	private int destinationPort;
	private String sourceIP;
	private String destinationIP;
	private String strData;
	
	/* Get and Set Methods */
	protected int getSourcePort() {
		return sourcePort;
	}

	protected int getDestinationPort() {
		return destinationPort;
	}

	protected String getSourceIP() {
		return sourceIP;
	}

	protected String getDestinationIP() {
		return destinationIP;
	}

	protected String getStrData() {
		return strData;
	}
	
	protected void setStrData(String strData) {
		this.strData = strData;
	}
/* -------------------------------- */
	
	
	
	protected TransportSocket(String destinationIP, int destinationPort) {
		this.destinationIP = destinationIP;
		this.destinationPort = destinationPort;
	}
	
	protected TransportSocket(String destinationIP, int destinationPort,
							  String sourceIP, int sourcePort) {
		this.destinationIP = destinationIP;
		this.destinationPort = destinationPort;
		this.sourceIP = sourceIP;
		this.sourcePort = sourcePort;
	}
	

	
}	// end TransportSocket
