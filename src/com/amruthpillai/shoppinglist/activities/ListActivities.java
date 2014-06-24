package com.amruthpillai.shoppinglist.activities;

// Imports
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ListActivities {

	File shoppingListFile = new File("shoppinglist.txt");

	/**
	 * Display the Shopping List
	 * 
	 * @param shoppingList
	 *            An ArrayList that holds all the List Items
	 */
	public void displayList() {

		List<String> shoppingListArray = null;

		try {
			// Check if Shopping List is already created, otherwise show
			// instruction.
			if (shoppingListFile.exists()) {
				shoppingListArray = FileUtils.readLines(shoppingListFile);
			} else {
				System.out
						.println("The file does not exist, please create a new Shopping List!\n");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Here's the Shopping List: ");
		for (String listItem : shoppingListArray)
			if (listItem != null)
				System.out.println(listItem);

		System.out.println();
	}

	/**
	 * Remove an Item from the Shopping List
	 * 
	 * @param shoppingList
	 *            An ArrayList that holds all the List Items
	 */
	public void removeItem(Scanner input) {
		// Check if Shopping List is already created, otherwise show
		// instruction.
		if (shoppingListFile.exists()) {
			RemoveItem.removeLineFromFile(shoppingListFile, input);
		} else {
			System.out
					.println("The file does not exist, please create a new Shopping List!\n");
		}
	}

	/**
	 * Add an Item to the Shopping List
	 * 
	 * @param shoppingList
	 *            An ArrayList that holds all the List Items
	 * @param input
	 *            A Scanner object to hold input from the user
	 */
	public void addItem(Scanner input) {
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
	 * Clear the Shopping List In Other Words, Delete the Complete File
	 * 
	 * @param shoppingList
	 *            An ArrayList that holds all the List Items
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
				System.out
						.println("The file does not exist, please create a new Shopping List!\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
