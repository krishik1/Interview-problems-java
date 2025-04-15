package desginpatterns.adapter;

public interface PaymentAdapter {
	double balanceInquiry();
	void processPayment(double amount);
}
