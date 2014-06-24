package com.amruthpillai.shoppinglist;

// Imports
import java.util.Scanner;

import com.amruthpillai.shoppinglist.activities.ListActivities;

/**
 * Simple Shopping List in Java
 * 
 * @author Amruth Pillai
 * @version 1.6
 */
public class ShoppingList {
	public static void main(String[] args) {

		// Looping element for Repetitive Flow in Switch
		boolean looper = true;

		// Object to initialize the ListActivities class
		ListActivities listActivities = new ListActivities();

		// Scanner element initialized to take input from the user
		Scanner input = new Scanner(System.in);

		do {
			// Main Menu of Functions
			System.out.print("1) Add a new item\n" + "2) Remove an item\n"
					+ "3) Remove all items\n" + "4) Display the list\n"
					+ "5) Terminate the app\n\n" + "Enter an option: ");
			int option = Integer.parseInt(input.nextLine());

			// Switch for Menu
			switch (option) {

			case 1:
				// Add an Item to the Shopping List
				listActivities.addItem(input);
				break;

			case 2:
				// Remove an Item from the Shopping List
				listActivities.removeItem(input);
				break;

			case 3:
				// Clear the Shopping List
				listActivities.clearList();
				break;

			case 4:
				// Display the Shopping List
				listActivities.displayList();
				break;

			case 5:
				// Terminate the application by inverting the looper boolean
				looper = !looper;
				System.out.println("Goodbye!");
				break;

			default:
				System.out
						.println("This was an invalid option, please try again\n!");
				break;

			}
		} while (looper);

		// Closing the Scanner element 'input' to prevent resource leakage
		// http://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed
		if (input != null)
			input.close();

	}
}
