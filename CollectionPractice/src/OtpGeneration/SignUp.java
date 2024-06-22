package OtpGeneration;

public class SignUp {
	OtpSender otpSender;
	
	public void click(String in) {
		if(in.equalsIgnoreCase("email")) {
			otpSender = new EmailOtpsender();
			System.out.println("OTP is "+otpSender.generateOtp() +" Through "+in.toUpperCase());
		} else if(in.equalsIgnoreCase("sms")) {
			otpSender = new SmsOtpsender();
			System.out.println("OTP is "+otpSender.generateOtp() +" Through "+in.toUpperCase());
		}
		
	}
}
