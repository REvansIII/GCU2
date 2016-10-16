package vendingMachine;

public abstract class Snack extends Product implements Comparable<Snack> {

	public Snack() {

	}

	public Snack(String snackName, double price) {
		super(snackName, price);

		this.snackName = snackName;
		this.price = price;

	}

	public Snack(Product product) {
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

	@Override
		public int compareTo(Product o) {
			int comparison = this.getsnackName().compareTo(o.getsnackName());
			
			if (comparison != 0){		
				return comparison;
			} 
			if (comparison == 0){
				 return comparison;
			}	
			else if (this.getPrice() > o.getPrice()){
					return -1;
			}
			 if (this.getPrice() < o.getPrice()){
					return 1;
			}
			return comparison;
			
			
			 
			
			}

}
