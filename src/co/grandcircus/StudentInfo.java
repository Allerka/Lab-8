package co.grandcircus;

import java.util.Scanner;

import co.grandcircus.Validator;

public class StudentInfo {

	public static void main(String[] args) {
		// initial setup
		Scanner scan = new Scanner(System.in);
		String cont = "y";
		String subChoice = "y";

		// user input and displaying returned information
		System.out.println("Welcome to the student database.");
		while (cont.equalsIgnoreCase("y")) {
			subChoice = "y";
			int selection = Validator.getInt(scan, "Which student would you like to learn more about? (Enter 1-10): ",
					1, 10);
			System.out.println("Student " + selection + " is " + names(selection));
			while (subChoice.equalsIgnoreCase("y")) {
				String information = Validator.getStringMatchingRegex(scan,
						"Would you like to know their: primary language or hometown? ", "(language|hometown)");
				if (information.equals("language")) {
					System.out.println(names(selection) + "'s primary language is " + language(selection));
				} else if (information.equals("hometown")) {
					System.out.println(names(selection) + " is from " + hometown(selection));
				}
				subChoice = Validator.getStringMatchingRegex(scan, "Would you like to know more about them? (y/n) ",
						"[YyNn]");
			}
			cont = Validator.getStringMatchingRegex(scan, "Would you like to see another student? (y/n) ", "[YyNn]");
		}
		System.out.println("Exiting!");
	}

	// store and retrieve names
	public static String names(int selection) {
		int i = selection - 1;
		String[] names = { "Alex Girard", "Conrad Dugalle", "Lucy Nakata", "Ali Giseroux", "Dendrin Jourengeld",
				"Marie St. Claire", "Sophie Kalomar", "Mileena Leguin", "Lyara Keshin", "Martia Haspin" };
		return names[i];
	}

	// store and retrieve languages
	public static String language(int selection) {
		int i = selection - 1;
		String[] languages = { "Sancais", "Sancais", "Weihongo", "Dorlish", "Saenska", "Keutche", "Latibaa", "Sancais",
				"Hachiwen", "Solish" };
		return languages[i];
	}

	// store and retrieve hometown
	public static String hometown(int selection) {
		int i = selection - 1;
		String[] hometowns = { "Montblanc", "Montblanc", "Jekith", "Jorandek", "Kunskaborg", "Noswitz",
				"The Citadel of Light", "Montblanc", "the Southern Sun", "the SAS Bastille" };
		return hometowns[i];
	}
}
