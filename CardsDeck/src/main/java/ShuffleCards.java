package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShuffleCards {


	public int shuffleCardsToPlayers(String players) throws Exception {

		Deck deck = new Deck();
		Map<String, String> mapOfCards = new HashMap<>();
		int cardsCheck = 0, playersCheck = 0;
		
		try {
			int numberOfPlayers = Integer.parseInt(players);

			if (numberOfPlayers < 1 || numberOfPlayers > 52) {
				System.out.println("The number of players should be between 1 and 52");
				return -1;
			} else {
				int numberOfCards = 52 / numberOfPlayers;

				Random rand = new Random();
						while (playersCheck < numberOfPlayers) {
							System.out.print("user-" + (playersCheck + 1) + " ");
							while (cardsCheck < numberOfCards) {
								int r = rand.nextInt(4);
								int s = rand.nextInt(13);
								String key = r + "" + s;
								if (mapOfCards.get(key) == null) {
									mapOfCards.put(key, deck.cards[r][s]);
									System.out.print(deck.cards[r][s] + " ");
									cardsCheck++;
								}
							}
							System.out.println();
							cardsCheck = 0;
							playersCheck++;
						}
				System.out.println("Remaining number of cards = " + 52 % numberOfPlayers);
			}
		} catch (Exception e) {
			System.out.println("Invalid entry!! The number of players should be a number between 1 and 52");
			return -2;
		}
		return mapOfCards.size();
	}
}
