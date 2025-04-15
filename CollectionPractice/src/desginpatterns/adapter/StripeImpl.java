package desginpatterns.adapter;

public class StripeImpl implements Stripe {

	@Override
	public void stripePayProcessPayment(double amount) {
		if(amount>0.0) {
			System.out.println("Payment Done Successfully By Stripe. ");
		} else {
			System.out.println("Stripe Payment got Failed. ");
		}
	}

	@Override
	public double getBalance() {
		return 1000.0;
	}

}
