package desginpatterns.adapter;

public class RazorPayPaymentAdapter implements PaymentAdapter {
	private final RazorPay razorPay;
	
	public RazorPayPaymentAdapter(RazorPay razorPay) {
		this.razorPay=razorPay;
	}

	@Override
	public double balanceInquiry() {
		return razorPay.showBalance();
	}

	@Override
	public void processPayment(double amount) {
		razorPay.razorPayProcessPayment(amount);
	}

}
