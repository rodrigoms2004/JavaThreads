
public class NotThreadSafe {
	StringBuilder builder = new StringBuilder();
	
	public void add(String text) {
		this.builder.append(text);
	}
	
	public String getBuilder() {
		return builder.toString();
	}
}	// end class
