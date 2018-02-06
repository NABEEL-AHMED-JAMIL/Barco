package service;

public enum RequestMethod {
	
	Get("GET"), Head ("HEAD"),
	Post ("POST"), Put ("PUT"),Patch ("PATCH"),
	Delete ("DELETE"), Options ("OPTIONS");
	
	private String requestType;
	
	RequestMethod(String requestType) { this.requestType = requestType; }
	
	public String getRequestType() { return this.requestType; }
	
}


