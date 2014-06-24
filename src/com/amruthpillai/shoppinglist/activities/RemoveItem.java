package com.amruthpillai.shoppinglist.activities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveItem {
	public static void removeLineFromFile(File shoppingListFile, Scanner input) {

		try {

			System.out
					.println("Which item do you want to remove? Type the name exactly as it is!");
			String lineToRemove = input.nextLine();

			if (!shoppingListFile.isFile()) {
				System.out.println("Parameter is not an existing file!");
				return;
			}

			// Construct the new file that will later be renamed to the original
			// filename.
			File tempFile = new File(shoppingListFile.getAbsolutePath()
					+ ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(
					shoppingListFile));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {
				if (!line.trim().equals(lineToRemove)) {
					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			// Delete the original file
			if (!shoppingListFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(shoppingListFile))
				System.out.println("Could not rename file");

		}

		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
