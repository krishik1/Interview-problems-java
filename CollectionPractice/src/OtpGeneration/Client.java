package OtpGeneration;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select SIGN IN Method : ");
		System.out.println("SMS or Email");
		String in = sc.nextLine();
		SignUp signUp = new SignUp();
		signUp.click(in);
	}
}
