package ecart;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Client {
	public static void main(String[] args) {
		List<CartItem> cart = Arrays.asList(new CartItem("12345", "Track Suit", 500, "Puma"),
				new CartItem("12845", "T-Shirt", 300, "Highlander"), new CartItem("12846", "Joggers", 2000, "Nike"));

		Wallet wallet = new Wallet("rajkrish@Icici", 6000.0);
		CompletableFuture<Void> orderFuture = placeOrder(cart, wallet).thenAccept(order -> {
	            System.out.println("Wallet Balance: " + wallet.getBalance());
	            System.out.println("Order placed successfully. Your order will be delivered in 48 hours.");
	        }).exceptionally(ex -> {
	            System.out.println("You are unable to place this order: " + ex.getMessage());
	            return null;
	        });
		 
		orderFuture.join();
	}

	private static CompletableFuture<Void> placeOrder(List<CartItem> cart, Wallet wallet) {
		
		return createOrder(cart).thenCompose(order -> {
			return processPayment(order, wallet);}).thenAccept(
					bill -> {
						System.out.println("Bill processed: "+bill );
					}).exceptionally(ex -> {
			            System.out.println("Error: " + ex.getMessage());
			            return null;});
					
	
	}
	private static CompletableFuture<Bill> processPayment(Order order, Wallet wallet) {
        return CompletableFuture.supplyAsync(() -> {
            if (order.getTotal() <= wallet.getBalance()) {
                Bill bill = new Bill(
                        "BNO" + ThreadLocalRandom.current().nextInt(10000), 
                        order.getTotal(),
                        MODE.UPI, 
                        LocalDateTime.now().plusHours(48) 
                );
                wallet.setBalance(wallet.getBalance() - order.getTotal()); 
                System.out.println("Billing Details: " + bill); 
                return bill; 
            } else {
                throw new RuntimeException("Insufficient balance.");
            }
        });
    }

	private static CompletableFuture<Order> createOrder(List<CartItem> cart) {

		return CompletableFuture.supplyAsync(() -> {
			try {
				if (cart == null || cart.isEmpty()) {
					throw new IllegalArgumentException("Cart is Empty .");
				}

				System.out.println("Ordering Items: " + cart);
				System.out.println();
				Double totalSum = cart.stream().map(x -> x.getPrice()).reduce(0.0, Double::sum);

				Order order = new Order("ORD" + new Random().nextInt(), cart.size(), totalSum);
				System.out.println("Order created: " + order);
				System.out.println();
				return order;

			} catch (Exception e) {
				throw new RuntimeException("Error in creating order: " + e.getMessage());
			}
		});
	}
}
