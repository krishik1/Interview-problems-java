package desginpatterns.adapter;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PaymentAdapter paymentAdapter = ChooseStrategy.getStrategy(sc.next());
		System.out.println("Balance is :"+paymentAdapter.balanceInquiry());
		paymentAdapter.processPayment(200);
	}

}
