package Behaviour.strategy.design.pattern;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		PathCalculater pc=null;
		try {
			pc = GoogleMapFactory.getMode(in);
			pc.calculateDistance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
