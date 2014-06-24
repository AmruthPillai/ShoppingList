package com.amruthpillai.shoppinglist.activities;

// Imports
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ListActivities {

	// Initialize shoppingListFile to a new file called 'shoppinglist.txt'
	File shoppingListFile = new File("shoppinglist.txt");

	/**
	 * Display the Shopping List
	 * 
	 */
	public void displayList() {

		// Initialize a list to hold all items
		List<String> shoppingList = null;

		try {

			// Check if Shopping List is already created, otherwise show
			// instruction.
			if (shoppingListFile.exists()) {

				// Read all items from shoppingListFile and store in
				// shoppingList
				shoppingList = FileUtils.readLines(shoppingListFile);

			} else {

				// If file does not exist, throw an error.
				System.out
						.println("The file does not exist, please create a new Shopping List!\n");
				return;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Here's the Shopping List: ");

		// For each item stored in the shoppingList, iterate the loop and
		// display the item
		for (String listItem : shoppingList)
			if (listItem != null)
				System.out.println(listItem);

		System.out.println();
	}

	/**
	 * Remove an Item from the Shopping List
	 * 
	 * @param input
	 *            A Scanner object to hold input from the user
	 */
	public void removeItem(Scanner input) {

		// Check if Shopping List is already created, otherwise show
		// instruction.
		if (shoppingListFile.exists()) {

			// Access RemoveItem class and call removeLineFromFile to delete a
			// particular item
			RemoveItem.removeLineFromFile(shoppingListFile, input);

		} else {

			// If file does not exist, throw an error.
			System.out
					.println("The file does not exist, please create a new Shopping List!\n");

		}

	}

	/**
	 * Add an Item to the Shopping List
	 * 
	 * @param input
	 *            A Scanner object to hold input from the user
	 */
	public void addItem(Scanner input) {

		// Take input from the user on the name of the item
		System.out.print("Enter the name of the item: ");
		String newItem = input.nextLine();

		try {

			// Even if Shopping List does not exist, writing to shoppingListFile
			// will create a new file.
			FileUtils.write(shoppingListFile, newItem + "\n", true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clear the Shopping List and Delete the File
	 * 
	 */
	public void clearList() {
		try {
			
			// Check if Shopping List is already created, otherwise show
			// instruction.
			if (shoppingListFile.exists()) {
				
				// Force Delete the shoppingListFile to clear all items.
				FileUtils.forceDelete(shoppingListFile);
				System.out.println("The Shopping List has been cleared!");
				
			} else {
				
				// If file does not exist, throw an error.
				System.out
						.println("The file does not exist, please create a new Shopping List!\n");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
