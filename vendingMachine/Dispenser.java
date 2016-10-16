package vendingMachine;

import java.util.*;

public class Dispenser {

	private String name;
	private int numOfProducts;
	private static ArrayList<Product> inventory = new ArrayList<Product>();

	public Dispenser() {

	}

	public Dispenser(String name) {
		this.setName(name);
	}

	public Dispenser(Product product) {

	}

	public void setContents(ArrayList<Product> inventory) {

		Dispenser.inventory = inventory;
	}

	List<Product> getContents() {
		return inventory;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfProducts() {
		return numOfProducts;
	}

	public void setNumOfProducts(int numOfProducts) {
		this.numOfProducts = numOfProducts;
	}

	public static void displayProducts() {
		System.out.println(inventory.toString());
	}

	public static void main(String[] args) {

		inventory.add(new Candy("Hershey's  ", .50));
		inventory.add(new Chips("Doritos ", .50));
		inventory.add(new Gum("Doublemint ", .50));
		inventory.add(new Candy("Mars  ", .50));
		inventory.add(new Gum("Big Red  ", .50));
		inventory.add(new Chips("Fritos  ", .50));
		inventory.add(new Chips("Lays  ", .50));
		inventory.add(new Chips("Cheetos  ", .50));
		inventory.add(new Drink("Coke ", .75));
		inventory.add(new Drink("Mountain Dew ", .75));
		inventory.add(new Drink("Pepsi ", .75));

		Dispenser.displayProducts();
		
		
		System.out.println("Hershey's".compareTo("Doritos")); // Hershey's 4 greater than..
		System.out.println("Pepsi".compareTo("Pepsi")); // equal Products
		System.out.println("Mars".compareTo("Pepsi")); // Mars 3 less than Pepsi

			}
		
	

}
