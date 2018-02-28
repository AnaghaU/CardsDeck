package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ShuffleCards {

	public int shuffleCardsToPlayers(String players) throws Exception {

		Deck deck = new Deck();
		Map<String, String> mapOfCards = new HashMap<>();
		List<Player> playersList = new ArrayList<Player>();
		Player player;
		int cardsCheck = 0, playersCheck = 0;
		List<String> cardsToPlayer;

		try {
			int numberOfPlayers = Integer.parseInt(players);

			if (numberOfPlayers < 1 || numberOfPlayers > 52) {
				System.out.println("The number of players should be between 1 and 52");
				return -1;
			} else {
				int numberOfCards = 52 / numberOfPlayers;

				Random rand = new Random();
				while (playersCheck < numberOfPlayers) {
					player = new Player();
					cardsToPlayer = new ArrayList<>();
					while (cardsCheck < numberOfCards) {
						int r = rand.nextInt(4);
						int s = rand.nextInt(13);
						String key = r + "" + s;
						if (mapOfCards.get(key) == null) {
							mapOfCards.put(key, deck.cards[r][s]);
							cardsToPlayer.add(deck.cards[r][s]);
							cardsCheck++;
						}
					}					
					player.setCards(cardsToPlayer);
					cardsCheck = 0;
					playersCheck++;
					playersList.add(player);
				}
				for(int k = 0; k < playersList.size() ; k++){
					System.out.print("Player : "+ (k+1)+" ");
					System.out.println(playersList.get(k).getCards());
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
