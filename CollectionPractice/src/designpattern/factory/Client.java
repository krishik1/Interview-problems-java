package designpattern.factory;

import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		DataBase db = null;
		Router.route(input, db);
		
	}
	
}
