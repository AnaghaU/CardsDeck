package main.java;

public class Deck {

	 String[][] cards = new String[4][13];

	public Deck() {
		StringBuilder cardName = new StringBuilder("");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				switch (i) {
				case 0:
					cardName = new StringBuilder("spades:");
					break;
				case 1:
					cardName = new StringBuilder("clubs:");
					break;
				case 2:
					cardName = new StringBuilder("diamonds:");
					break;
				case 3:
					cardName = new StringBuilder("hearts:");
					break;
				}

				switch (j) {
				case 9:
					cardName.append("Jack");
					break;
				case 10:
					cardName.append("Queen");
					break;
				case 11:
					cardName.append("King");
					break;
				case 12:
					cardName.append("A");
					break;
				default:
					cardName.append(String.valueOf(j + 2));
					break;
				}
				cards[i][j] = cardName.toString();
			}
		}
	}

}
