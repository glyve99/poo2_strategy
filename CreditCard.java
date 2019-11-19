public class CreditCard {
	private double amount;
	private String number;
	private String date;
	private String cvv;
	
	public CreditCard(String number, String date, String cvv) {
		this.amount = 100000.00;
		this.number = number;
		this.date = date;
		this.cvv = cvv;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}
	
}