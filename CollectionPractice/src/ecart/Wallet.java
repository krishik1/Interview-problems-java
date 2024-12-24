package ecart;

public class Wallet {
	private String walletId;
	private Double balance;
	
	
	
	public Wallet(String walletId, Double balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}
	public Double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", balance=" + balance + "]";
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
}
