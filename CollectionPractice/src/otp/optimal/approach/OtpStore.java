package otp.optimal.approach;

import java.time.LocalDateTime;

public class OtpStore {
	
	private String otp;
	private LocalDateTime time;
	public OtpStore(String otp, LocalDateTime time) {
		this.otp = otp;
		this.time = time;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	

}
