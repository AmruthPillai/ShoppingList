package com.amruthpillai.shoppinglist;

// Imports
import java.util.ArrayList;
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
		
		/**
		 * Looping element for Repetitive Flow in Switch
		 */
		boolean looper = true;
		
		/**
		 * ArrayList element which takes in only <String> holding all our Shopping List Items
		 */
		ArrayList<String> shoppingList = new ArrayList<String>();
		
		/**
		 * Scanner element intialized to take input from the user
		 */
		Scanner input = new Scanner(System.in);
		
		while (looper) {
			/**
			 * Main Menu of Functions
			 */
			System.out.print("1) Add a new item\n2) Remove all items\n3) Display the list\n4) Terminate the app\n\nEnter an option: ");
			int option = Integer.parseInt(input.nextLine());

			switch (option) {

			case 1:
				/**
				 * Add an Item to the Shopping List
				 */
				ListActivities.addItem(shoppingList, input);
				break;

			case 2:
				/**
				 * Clear the Shopping List
				 */
				ListActivities.clearList(shoppingList);
				break;

			case 3:
				/**
				 * Display the Shopping List
				 */
				ListActivities.displayList(shoppingList);
				break;
				
			case 4:
				looper = false;
				System.out.println("Goodbye!");
				break;

			default:
				System.out.println("This was an invalid option, please try again\n!");
				break;

			}
		}
		
		/**
		 * Closing the Scanner element 'input' to prevent resource leakage
		 * Read: http://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed
		 */
		input.close();
		
	}
}
