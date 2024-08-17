package MultiThreading.helloWorldprinter;

public class Client {
	public static void main(String[] args) {
		HelloWorldPrinter h = new HelloWorldPrinter();
		//h.run(); -This is executed by main thread
		Thread th = new Thread(h);//This constructor will accept the parameter of runnable
		th.start();
		System.out.println("current thread is : "+Thread.currentThread().getName());//-main thread
	}
}
