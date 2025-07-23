package Exception;

public class Main {
	void doSomethingElse(int x){
		if(x%2==0) {
			throw new EvenNumberException(400, "Even number is not allowed");
		}
	}
	public static void main(String[] args) throws ClassNotFoundException {
		Main main = new Main();
		//main.doSomethingElse(10);
		Handle handle=new Handle();
		System.out.println(handle.handler(10));
	}

}
