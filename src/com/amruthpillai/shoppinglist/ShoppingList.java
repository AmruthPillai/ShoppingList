package com.amruthpillai.shoppinglist;

// Imports
import java.util.Scanner;

import com.amruthpillai.shoppinglist.activities.ListActivities;

/**
 * Simple Shopping List in Java
 * 
 * @author Amruth Pillai
 * @version 1.0
 */
public class ShoppingList {
	public static void main(String[] args) {
		
		// Looping element for Repetitive Flow in Switch
		boolean looper = true;
		
		// Scanner element initialized to take input from the user
		Scanner input = new Scanner(System.in);
		
		while (looper) {
			
			// Main Menu of Functions
			System.out.print("1) Add a new item\n2) Remove an item\n3) Remove all items\n4) Display the list\n5) Terminate the app\n\nEnter an option: ");
			int option = Integer.parseInt(input.nextLine());
			
			// Switch for Menu
			switch (option) {

			case 1:
				// Add an Item to the Shopping List
				ListActivities.addItem(input);
				break;
				
			case 2:
				// Remove an Item from the Shopping List
				ListActivities.removeItem(input);
				break;

			case 3:
				// Clear the Shopping List
				ListActivities.clearList();
				break;

			case 4:
				// Display the Shopping List
				ListActivities.displayList();
				break;
				
			case 5:
				looper = false;
				System.out.println("Goodbye!");
				break;

			default:
				System.out.println("This was an invalid option, please try again\n!");
				break;

			}
		}
		
		// Closing the Scanner element 'input' to prevent resource leakage
		// Read: http://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed
		if (input != null)
			input.close();
		
	}
}
