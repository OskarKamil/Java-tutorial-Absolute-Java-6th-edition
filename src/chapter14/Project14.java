package chapter14;

import java.util.Scanner;
import java.util.ArrayList;

public class Project14 {

	static ArrayList<String> checkDuplicates(ArrayList<String> source) {
		ArrayList<String> duplicates = new ArrayList<>();
		for (int i = 0; i < source.size() - 1; i++) {
			for (int j = i + 1; j < source.size(); j++)
				if (source.get(i).equalsIgnoreCase(source.get(j)))
					if (!duplicates.contains(source.get(i)))
						duplicates.add(source.get(i));
		}

		return duplicates;
	}

	static ArrayList<String> removeDuplicates(ArrayList<String> source, ArrayList<String> dups) {
		for (String el : dups) {
			if (source.contains(el))
				while (!(source.indexOf(el) == source.lastIndexOf(el)))
					source.remove(source.lastIndexOf(el));
		}
		return source;
	}

	public static void main(String[] args) {
		System.out.println("Program has started\n");

		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> taskList = new ArrayList<String>();

		String input = null;

		do {
			if (!(input == null))
				taskList.add(input);
			System.out.println("Enter your task entry or enter \"n\" to finish  ");
			input = keyboard.nextLine();
		} while (!(input.equalsIgnoreCase("n")));
		System.out.println("\nAdding tasks finished\nDo you want to see your task list? y/n");
		input = keyboard.nextLine();

		System.out.println("\nBUT FIRST IT WILL CHECK FOR DUPLICATES");
		ArrayList<String> dups = checkDuplicates(taskList);
		System.out.println(dups);

		taskList = removeDuplicates(taskList, dups);

		if (input.equalsIgnoreCase("y")) {
			System.out.println("\nYou have " + taskList.size() + " entries:");
			for (String el : taskList)
				System.out.println("-" + el);
		} else if (input.equalsIgnoreCase("n"))
			System.out.println("Ok, nothing will be displayed");

		keyboard.close();
		System.out.println("\nThe program will close now");
		System.exit(0);
	}
}
