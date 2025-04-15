package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionFlatMap {
	public static void main(String[] args) {
		List<Transaction> transactions = Arrays.asList(
				new Transaction(Arrays.asList(new Item("Item1", 30), new Item("Item2", 60))),
				new Transaction(Arrays.asList(new Item("Item3", 20), new Item("Item4", 40))),
				new Transaction(Arrays.asList(new Item("Item5", 70), new Item("Item6", 10))));
		
		 List<Item> res = transactions.stream().flatMap(transaction->transaction.getItems().stream())
		.filter(val->val.getAmount()>30).collect(Collectors.toList());
		 res.forEach(System.out::println);
		 
	}

}
