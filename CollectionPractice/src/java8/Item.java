package java8;

public class Item {
	private String name;
    private double amount;

    public Item(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name + ": " + amount;
    }
}
