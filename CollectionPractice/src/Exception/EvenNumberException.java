package Exception;

public class EvenNumberException extends RuntimeException {
	int code;
	String message;

	public EvenNumberException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	@Override
	public String toString() {
		return "EvenNumberException [code=" + code + ", message=" + message + "]";
	}
	

}
