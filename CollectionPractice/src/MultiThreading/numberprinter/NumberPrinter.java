package MultiThreading.numberprinter;

public class NumberPrinter implements Runnable {
	private int number;
	 public NumberPrinter(int num) {
		 number = num;
	 }

	@Override
	public void run() {
		System.out.println(number+" Thread  : "+Thread.currentThread().getName());
	}

}
