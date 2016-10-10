package vendingMachine;

public abstract class Product {

	protected String snackName;
	protected double price;

	Product() {
	}

	Product(String initialSnackName, double initialPrice){
		this.snackName = snackName;
		this.price = price;
	}
	
	Product(Product product){
		this.snackName = product.snackName;
		this.price = product.price;
		
	}
	
	public abstract void setsnackName(String snackName1);
	
	
	public abstract String getsnackName();		


	public abstract void setPrice(double price1);
	

	public abstract double getPrice();
	
	
	public abstract String toString();

}
