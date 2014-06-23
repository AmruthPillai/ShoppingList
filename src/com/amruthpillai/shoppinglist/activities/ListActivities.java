package com.amruthpillai.shoppinglist.activities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ListActivities {
	
	static File shoppingListFile = new File("shoppinglist.txt");
	
	/**
	 * Display the Shopping List
	 * 
	 * @param shoppingList An ArrayList that holds all the List Items
	 */
	public static void displayList() {
		
		List<String> shoppingListArray = null;
		
		try {
			shoppingListArray = FileUtils.readLines(shoppingListFile);
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
	 * Add an Item to the Shopping List
	 * 
	 * @param shoppingList An ArrayList that holds all the List Items
	 * @param input A Scanner object to hold input from the user
	 */
	public static void addItem(Scanner input) {
		System.out.print("Enter the name of the item: ");
		String newItem = input.nextLine();
		
		try {
			FileUtils.write(shoppingListFile, newItem);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clear the Shopping List
	 * In Other Words, Delete the Complete File
	 * 
	 * @param shoppingList An ArrayList that holds all the List Items
	 */
	public static void clearList() {
		try {
			FileUtils.forceDelete(shoppingListFile);
			System.out.println("The Shopping List has been cleared!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
