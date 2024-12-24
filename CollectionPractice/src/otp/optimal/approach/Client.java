package otp.optimal.approach;

import java.util.Scanner;

public class Client {
	private static final String userId = "Krishik";
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		OtpGeneration otpGen = OtpGeneration.getInstance();
		
		String otp = otpGen.generateOtp(userId);
		System.out.println("OTP Is : "+otp);
		System.out.print("Enter Your Otp : ");
		otpGen.validateOtp(userId, sc.next());
		
		otpGen.printDb();
	}

}
