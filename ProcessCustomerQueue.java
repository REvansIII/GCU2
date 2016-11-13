package vendingMachine;

//Milestone Topic 7   by Robbie Evans III

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ProcessCustomerQueue extends GlobalInventoryManage {

	static ArrayList<String> custList = new ArrayList<String>();

	public ProcessCustomerQueue() {
	}

	public static void main(String[] args) {

		

		BufferedReader Buffer = null;

		try {
			String Line;
			Buffer = new BufferedReader(new FileReader("C:/Users/Robbie/Documents/CST115_Final_Project/Customers.csv"));

			// How to read file in java line by line?
			while ((Line = Buffer.readLine()) != null) {
				System.out.println(CSVtoArrayList(Line) + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (Buffer != null)
					Buffer.close();
			} catch (IOException Exception) {
				Exception.printStackTrace();
			}
		}
	}

	// CSV to ArrayList using Split Operation
	public static ArrayList<String> CSVtoArrayList(String CSV) {
		// ArrayList<String> custList = new ArrayList<String>();

		if (CSV != null) {
			String[] splitData = CSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					custList.add(splitData[i].trim());
				}
			}
		}

		return custList;

	}

	public static void first() { // i. Attempt to perform the requested purchase
									// (check availability)

		if (prodList.contains(custList)) {
			System.out.println(" available at " + prodList.indexOf(custList));

		}

	}

	public static void in() { /*
								 * If the item is available, perform the
								 * transaction using the functionality
								 * implemented in earlier milestones
								 * 
								 * Code from Dispenser.java
								 */
	/*	for (int i = 0; i < productList.length; i++) {
			lvCheckout.setItems(checkoutItems);
			if(productList[i] == null) {
				System.out.println("");
			} else {
			
			if(((Product) productList[i]).toString() == ("Snack")) {
				
				if(((Snack) productList[i]).getName().equals(custList)) {
				purchasedItems.add((Product) productList[i]);
				tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
				moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
				productList[i] = null;
				checkoutItems.removeAll(purchasedItems);
				checkoutItems.addAll(purchasedItems);
				lvCheckout.setItems(checkoutItems);*/


	}

	public static <E> String outOfStock() { /*
											 * If the item is unavailable,
											 * automatically generate an
											 * alternative selection
											 */

		Random random = new Random();

		int index = random.nextInt(prodList.size());
		String item = prodList.get(index);
		System.out.println("Your selection is unavailable " + item + " would make a great substitute");
		return item;
	}

	public static <E> void isEmpty(
			ArrayList<E> list) { /* If dispenser is empty */

		if (list == null) {
			System.out.println("Products are temporarily out of stock");
		}

	}

}
