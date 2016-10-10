package vendingMachine;

public class Candy extends Snack {

	public Candy() {

	}

	public Candy(String snackName, double price) {
		super(snackName, price);

		this.snackName = snackName;
		this.price = price;
	}
	
	public Candy(Product product){
		this.snackName = product.snackName;
		this.price = product.price;
	}

	@Override
	public void setsnackName(String snackName1) {
		snackName1 = snackName;
	}

	@Override
	public String getsnackName() {

		return snackName;
	}

	@Override
	public void setPrice(double price1) {
		price1 = price;

	}

	@Override
	public double getPrice() {

		return price;
	}

	@Override
	public String toString() {

		return snackName + price;
	}

}
