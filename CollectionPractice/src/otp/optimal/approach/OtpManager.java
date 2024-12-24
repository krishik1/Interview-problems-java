package otp.optimal.approach;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.concurrent.ConcurrentHashMap;

public class OtpManager {
	private static final int VALIDITY_DURATION = 5; // 5 minutes for OTP validity
	private static final int REUSE_DURATION = 24 * 60; // 24 hours for OTP reuse prevention
	private static final int HOLD_DURATION = 1; // 1 minute restriction between OTP generations

	private static final String userId = "Krishik";
	private final ConcurrentHashMap<String, List<OtpStore>> db = new ConcurrentHashMap<>();
	private final ConcurrentHashMap<String, LocalDateTime> userLastGeneratedTime = new ConcurrentHashMap<>();

	private static OtpManager instance;

	private OtpManager() {
	}

	public static synchronized OtpManager getInstance() {
		if (instance == null) {
			instance = new OtpManager();
		}
		return instance;
	}

	public synchronized String generateOtp(String userId) throws Exception {
		LocalDateTime now = LocalDateTime.now();

		// Check last OTP generation time
		if (userLastGeneratedTime.containsKey(userId)) {
			LocalDateTime lastGenerated = userLastGeneratedTime.get(userId);
			if (Duration.between(lastGenerated, now).toMinutes() < HOLD_DURATION) {
				long secondsRemaining = Duration.between(now, lastGenerated.plusMinutes(HOLD_DURATION)).toSeconds();
				throw new Exception("Cannot generate OTP. Please wait " + secondsRemaining + " seconds.");
			}
		}

		// Generate OTP and update user's last generation time
		String otp = generateRandomOtp();
		userLastGeneratedTime.put(userId, now);

		db.putIfAbsent(userId, new ArrayList<>());
		List<OtpStore> otpList = db.get(userId);

		// Clean expired OTPs (older than 24 hours)
		cleanExpiredOtps(otpList, REUSE_DURATION);

		// Check for recently generated OTP
		for (OtpStore otpStore : otpList) {
			if (isWithinDuration(otpStore.getTime(), VALIDITY_DURATION)) {
				throw new Exception("An OTP was already generated for this user within the last 5 minutes.");
			}
		}

		// Check for duplicate OTP in the last 24 hours
		for (OtpStore otpStore : otpList) {
			if (otpStore.getOtp().equals(otp)) {
				throw new Exception("This OTP has already been used in the past 24 hours.");
			}
		}

		// Add the new OTP to the user's history
		otpList.add(new OtpStore(otp, now));
		return otp;
	}

	public boolean validateOtp(String userId, String otp) throws Exception {
		if (!db.containsKey(userId)) {
			throw new Exception("User does not exist.");
		}

		List<OtpStore> otpList = db.get(userId);

		for (OtpStore otpStore : otpList) {
			if (otpStore.getOtp().equals(otp)) {
				if (isWithinDuration(otpStore.getTime(), VALIDITY_DURATION)) {
					System.out.println("OTP is valid for user ID: " + userId);
					return true;
				} else {
					throw new Exception("OTP has expired.");
				}
			}
		}

		throw new Exception("Invalid OTP for user ID: " + userId);
	}

	private void cleanExpiredOtps(List<OtpStore> otpList, int maxDuration) {
		otpList.removeIf(otpStore -> !isWithinDuration(otpStore.getTime(), maxDuration));
	}

	private boolean isWithinDuration(LocalDateTime time, int maxDuration) {
		return Duration.between(time, LocalDateTime.now()).toMinutes() <= maxDuration;
	}

	private String generateRandomOtp() {
		return new SplittableRandom().ints(0, 10).limit(6)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	public void printDb() {
		System.out.println("Current state of the database:");
		db.forEach((userId, otpList) -> {
			System.out.println("User ID: " + userId);
			otpList.forEach(otpStore -> {
				System.out.println(" OTP: " + otpStore.getOtp() + ", Generated at: " + otpStore.getTime());
			});
		});
	}
	
	public static void main(String[] args) {
		OtpManager otpGen = OtpManager.getInstance();

        try {
            // Generate OTP
            String otp = otpGen.generateOtp(userId);
            System.out.println("Generated OTP: " + otp);

            // Attempt to generate another OTP immediately (should be restricted for 1 minute)
            System.out.println("Attempting to generate another OTP...");
            otpGen.generateOtp(userId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Wait for 1 minute before testing again
        try {
            Thread.sleep(60000); // Sleep for 1 minute
            String otp2 = otpGen.generateOtp(userId);
            System.out.println("Generated OTP after 1 minute: " + otp2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print database
        otpGen.printDb();
    }

}
