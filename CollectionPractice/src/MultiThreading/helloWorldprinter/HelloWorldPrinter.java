package MultiThreading.helloWorldprinter;

public class HelloWorldPrinter implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello World "+Thread.currentThread().getName());
		doSomeThing();
	}
	public void doSomeThing() {
		System.out.println("Do SomeThing "+Thread.currentThread().getName());
	}

}
