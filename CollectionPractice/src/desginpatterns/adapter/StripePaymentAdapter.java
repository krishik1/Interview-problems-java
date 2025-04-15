package desginpatterns.adapter;

public class StripePaymentAdapter implements PaymentAdapter {
	private final Stripe stripe;

	public StripePaymentAdapter(Stripe stripe) {
		this.stripe=stripe;
	}

	@Override
	public double balanceInquiry() {
		return stripe.getBalance();
	}

	@Override
	public void processPayment(double amount) {
		stripe.stripePayProcessPayment(amount);
	}

}
