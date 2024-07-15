package MultiThreadingANDSynchronization;

public class NumberPrinter implements Runnable{
	int in;
	 public NumberPrinter(int x) {
		 in = x;
	 }

	@Override
	public void run() {
		for(int i=0;i<in;i++) {
			System.out.print(i+" ");
		}
		
	}

}
