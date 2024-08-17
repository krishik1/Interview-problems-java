package MultiThreadingANDSynchronization;

import java.awt.print.PrinterAbortException;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		NumberPrinter p =new NumberPrinter(sc.nextInt());
		p.run();
		
	}

}
