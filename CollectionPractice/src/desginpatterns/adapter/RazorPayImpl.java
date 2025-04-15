package desginpatterns.adapter;

public class RazorPayImpl  implements RazorPay{

	@Override
	public void razorPayProcessPayment(double amount) {
		if(amount>0.0) {
			System.out.println("Payment Done Successfully By RazorPay. ");
		} else {
			System.out.println("RazorPay Payment got Failed. ");
		}
	}

	@Override
	public double showBalance() {
		return 2000.0;
	}

}
