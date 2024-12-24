package ecart;

public class Order {
	private String orderId;
	private int noOfItems;
	private Double total;
	
	public Order(String orderId, int noOfItems, Double total) {
		super();
		this.orderId = orderId;
		this.noOfItems = noOfItems;
		this.total = total;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", noOfItems=" + noOfItems + ", total=" + total + "]";
	}
	
	

}
