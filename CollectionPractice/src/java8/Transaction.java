package java8;

import java.util.List;

public class Transaction {
	private List<Item> items;

	public Transaction(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
}
