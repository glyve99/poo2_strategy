public class Order {
	private double totalCost = 0;
	private boolean isClosed = false;
	
	public void processOrder(PayStrategy strategy) {
		strategy.collectPaymentDetails();
	}
	
	public void setTotalCost(double cost) {
		this.totalCost = cost;
	}
	
	public double getTotalCost() {
		return this.totalCost;
	}
	
	public boolean isClosed() {
		return this.isClosed;
	}
	
	public void setClosed() {
		isClosed = true;
	}
}