package desginpatterns.adapter;

public class ChooseStrategy {
	public static PaymentAdapter getStrategy(String type) throws Exception {
		if(type.equals("razorpay")) {
			RazorPay razorPay = new RazorPayImpl();
			return new RazorPayPaymentAdapter(razorPay);
		} else if(type.equals("stripe")) {
			Stripe stripe = new StripeImpl();
			return new StripePaymentAdapter(stripe);
		} else {
			throw new Exception("Select Valid Input.");
		}
	}
}
