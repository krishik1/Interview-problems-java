package otp.optimal.approach;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.concurrent.ConcurrentHashMap;

public class OtpGeneration {
	private static final ConcurrentHashMap<String, List<OtpStore>> db = new ConcurrentHashMap<>();
	private static final String userId = "Jag@14";
	

	private static final int duration = 1;
	private static final int reuseDuration = 24 * 60;

	public static String generateOtp(String userId) throws Exception {
		String otp = generateRandomOtp();
		LocalDateTime now = LocalDateTime.now();
//		db.putIfAbsent(userId, new ArrayList<>());
		List<OtpStore> otpList = db.get(userId);
		cleanExpiredOtps(otpList, reuseDuration);
		for (OtpStore otpStore : otpList) {
			if (withInTheDuration(otpStore.getTime(), duration)) {
				throw new Exception("An OTP was already generated for this user recently.");
			}
			if (otpStore.getOtp().equals(otp)) {
				throw new Exception("This OTP has already been used in the past 24 hours.");
			}
		}
		otpList.add(new OtpStore(otp, now));
		db.put(userId, otpList);
		System.out.println("Generated OTP: " + otp);
		return otp;
	}

	private static void cleanExpiredOtps(List<OtpStore> otpList, int maxDuration) {
		otpList.removeIf(otpStore -> withInTheDuration(otpStore.getTime(), maxDuration));
	}

	private static String generateRandomOtp() {
		return new SplittableRandom().ints(0, 10).limit(6)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	private static boolean withInTheDuration(LocalDateTime time, int maxDuration) {
		return Duration.between(time, LocalDateTime.now()).toMinutes() >= maxDuration;
	}

	public static boolean validateOtp(String userId, String otp) throws Exception {
		if (!db.containsKey(userId)) {
			throw new Exception("User Does Not Exists");
		}

		List<OtpStore> otpList = db.get(userId);
		 for (OtpStore otpStore : otpList) {
	            if (otpStore.getOtp().equals(otp)) {
	                if (withInTheDuration(otpStore.getTime(), duration)) {
	                    System.out.println("OTP is valid for user ID: " + userId);
	                    return true;
	                } else {
	                    throw new Exception("OTP has expired.");
	                }
	            }
	        }

	        throw new Exception("Invalid OTP for user ID: " + userId);
	}

	

	public static void printDb() {
		System.out.println("Current state of db:");
		db.forEach((userId, otpList) -> {
			System.out.println("User ID: " + userId);
			otpList.forEach(otpStore -> {
				System.out.println(" OTP: " + otpStore.getOtp() + ", Generated at: " + otpStore.getTime());
			});
		});
	}
	public static void main(String[] args) {
		if(!db.containsKey(userId)) {
			db.put(userId, new ArrayList<>());
		}
		try {
			String otp = generateOtp(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
