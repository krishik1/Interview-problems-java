package ecart;

import java.time.LocalDateTime;

public class Bill {
	
	private String transactionNo;
    private Double amount;
    private MODE paymentMode;
    private LocalDateTime deliveryDate;
	public Bill(String transactionNo, Double amount, MODE paymentMode, LocalDateTime deliveryDate) {
		super();
		this.transactionNo = transactionNo;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "Bill [transactionNo=" + transactionNo + ", amount=" + amount + ", paymentMode=" + paymentMode
				+ ", deliveryDate=" + deliveryDate + "]";
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public MODE getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(MODE paymentMode) {
		this.paymentMode = paymentMode;
	}
	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
    
}
