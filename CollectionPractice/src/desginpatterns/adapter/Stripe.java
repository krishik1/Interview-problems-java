package desginpatterns.adapter;

public interface Stripe {
	void stripePayProcessPayment(double amount);
	double getBalance();
}
