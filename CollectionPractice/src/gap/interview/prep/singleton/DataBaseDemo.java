package gap.interview.prep.singleton;

public class DataBaseDemo {
	
	private String port;
	private String uri;
	private String username;
	private String password;
	
	
	public DataBaseDemo(String port, String uri, String username, String password) {
		super();
		this.port = port;
		this.uri = uri;
		this.username = username;
		this.password = password;
	}
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
