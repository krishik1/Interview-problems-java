package ecart;

public class CartItem {
	private String productId;
	private String name;
	private Double price;
	private String brand;
	public CartItem(String productId, String name, double price, String brand) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.brand = brand;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "CartItem [productId=" + productId + ", name=" + name + ", price=" + price + ", brand=" + brand + "]";
	}
	
	
	
	
}
