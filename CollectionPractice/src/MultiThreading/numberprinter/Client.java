package MultiThreading.numberprinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for(int i=0;i<100;i++) {
			NumberPrinter np = new NumberPrinter(i);
			es.execute(np);
		}

	}
	
}
