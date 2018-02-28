package main.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("Enter the number of players : ");
			Scanner scanner = new Scanner(System.in);
			String numberOfPlayers = scanner.nextLine();
			ShuffleCards shuffler = new ShuffleCards();
			shuffler.shuffleCardsToPlayers(numberOfPlayers);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
