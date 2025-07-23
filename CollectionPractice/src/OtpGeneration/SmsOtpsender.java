package OtpGeneration;

import java.util.Random;

public class SmsOtpsender implements OtpSender {

	@Override
	public String generateOtp() {
		StringBuilder otp =new StringBuilder();
		Random random = new Random();
		for(int i=0;i<6;i++) {
			otp.append(random.nextInt(10));
		}
		return otp.toString();
	}

}
