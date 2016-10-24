package vendingMachine;

public abstract class TransactionHandling {

	private final double nickel = .05;
	private final double dime = .10;
	private final double quarter = .25;
	private String notice;

	public TransactionHandling() {
	}

	public abstract double receivePayment();

	public abstract double returnChange();

	
	public String InsufficientFundsException(String notice1) {

		this.notice = notice1;
		return notice1;

	}

	public String SoldOutException(String notice2) {

		this.notice = notice2;
		return notice2;
	}

}
