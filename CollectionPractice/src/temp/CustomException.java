package temp;

public class CustomException extends RuntimeException {
	int code;
	//String message;
	public CustomException(int code,String message) {
		super(message);
		this.code = code;
		//this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	

}
