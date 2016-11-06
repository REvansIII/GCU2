package vendingMachine;

//Milestone 6 CST115

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GlobalInventoryManage {

	Scanner input;

	private String filename;

	static ArrayList<String> prodlist = new ArrayList<String>();

	GlobalInventoryManage() {
	}

	GlobalInventoryManage(String filename) {
		this.filename = filename;
	}

	public void readFile() {

		BufferedReader buffer = null;

		try {
			String line;

			buffer = new BufferedReader(new FileReader("//csv file source goes here"));

			// read file line by line
			while ((line = buffer.readLine()) != null) {
				System.out.println("CSV data: " + line);
				System.out.println("ArrayList data: " + csvConversion(line) + "\n");
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (buffer != null)
					buffer.close();
			}

			catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}

	// Split Operation

	public ArrayList<String> csvConversion(String csv) {

		if (csv != null) {
			String[] splitData = csv.split("\\s*,\\s*");

			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					prodlist.add(splitData[i].trim());
				}
			}

		}

		return prodlist;

	}

	// sort
	private static void sort() { /*
									 * I spent a lot of time playing with the
									 * recursive sort methods, but was unable to
									 * negotiate them error free
									 */

		Collections.sort(prodlist);
	}

	// name search
	public static void nameSearch() {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the product you are searching for.");

		String name = input.nextLine();

		for (int i = 0; i < prodlist.size(); i++) {
			if (name.equals(prodlist.get(i))) {
				System.out.println(name + " has been found at location " + prodlist.toString());

			} else {
				System.out.println("Product could not be located; please try again");

			}

		}

	}

	/* I am not sure that I need to loop here.  I am concerned that the process may overwrite each time;  
	*/

	public static void textDoc() throws Exception {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter("GlobalInventory.txt"));

			for (int i = 0; i < prodlist.size(); i++) {
				if (prodlist != null)
					writer.write(prodlist.get(i));

				System.out.println(prodlist);
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