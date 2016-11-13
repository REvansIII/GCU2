package vendingMachine;

//Milestone 6 CST115 (Revised 12Nov2016)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GlobalInventoryManage {

	static String filename;

	static ArrayList<String> prodList = new ArrayList<String>();

	Scanner input;

	GlobalInventoryManage() {
	}

	GlobalInventoryManage(String filename) {
		GlobalInventoryManage.filename = filename;
	}

	public static void main(String[] args) {

		readFile();
		sort();
		nameSearch();
		
	}

	public static void readFile() {
		BufferedReader Buffer = null;

		try {
			String Line;
			Buffer = new BufferedReader(new FileReader("C:/Users/Robbie/Documents/CST115_Final_Project/Inventory.csv"));

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
		// ArrayList<String> prodList = new ArrayList<String>();

		if (CSV != null) {
			String[] splitData = CSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					prodList.add(splitData[i].trim());
				}
			}
		}
		return prodList;

	}

	public static void setList(ArrayList<String> list) {
		prodList = list;
	}

	public static ArrayList<String> getList() {
		return prodList;

	}

	// sort
	static void sort() {
		Collections.sort(prodList);

	}

	// name search
	static String nameSearch() {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the product you are searching for? " + prodList.size() + " available");

		String in = input.nextLine();

		// for(int i = 0; i< prodList.size(); i++){
		if (prodList.contains(in)) {
			System.out.println(in + " available at " + prodList.indexOf(in));
		} else {
			System.out.println("Please make another selection");
		}
		// }
		return in;

	}

	/*
	 * I am not sure that I need to loop here. I am concerned that the process
	 * may overwrite each time;
	 */

	public static void textDoc() throws Exception {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter("GlobalInventory.txt"));

			for (int i = 0; i < prodList.size(); i++) {
				if (prodList != null)
					writer.write(prodList.get(i));

			}

		} catch (IOException e) {
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}

	}
}