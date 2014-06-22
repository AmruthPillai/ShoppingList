package com.amruthpillai.shoppinglist.activities;

import java.util.ArrayList;
import java.util.Scanner;

public class ListActivities {
	/**
	 * Display the Shopping List
	 * @param shoppingList An ArrayList that holds all the List Items
	 */
	public static void displayList(ArrayList<String> shoppingList) {
		for (String listItem : shoppingList) {
			if (listItem != null) {
				System.out.println("Here's the Shopping List: ");
				System.out.println(listItem);
				
				System.out.println();
				return;
			}
		}
		System.out.println("The Shopping List is empty!\n");
	}
	
	/**
	 * Add an Item to the Shopping List
	 * @param shoppingList An ArrayList that holds all the List Items
	 * @param input A Scanner object to hold input from the user
	 */
	public static void addItem(ArrayList<String> shoppingList, Scanner input) {
		System.out.print("Enter the name of the item: ");
		String newItem = input.nextLine();
		shoppingList.add(newItem);
	}

	/**
	 * Clear the Shopping List
	 * @param shoppingList An ArrayList that holds all the List Items
	 */
	public static void clearList(ArrayList<String> shoppingList) {
		shoppingList.clear();
		System.out.println("The Shopping List has been cleared!");
	}
}
