package test.java;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Deck;
import main.java.ShuffleCards;

public class DeckTest {

	static ShuffleCards shuffleCards;
	int checkDistinctElements;
	static List<String> testDataList;
	static String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\CardsTestCases.csv";
	String numberOfPlayers;

	@BeforeClass
	public static void initializeAll() throws Exception {
		
		String line = "";
		testDataList = new ArrayList<>();
		shuffleCards = new ShuffleCards();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		
		while((line = br.readLine()) != null) {
			String[] csvData = line.split(","); 
			testDataList.add(csvData[5]);
		}
		
	}
	
	/*To check if the number of players is divisible by 52, equal number of cards are distributed to them*/
	@Test
	public void testEqualCards() throws Exception {
		numberOfPlayers = testDataList.get(1);
		checkDistinctElements = shuffleCards.shuffleCardsToPlayers(numberOfPlayers);
			assertEquals(52, checkDistinctElements);
	}
	
	/*To check if the number of players is not divisible by 52, equal
	 * number of cards are distributed to them and the remaining number cards are displayed
	 */
	@Test
	public void testUnequalCards() throws Exception {
		numberOfPlayers = testDataList.get(2);
		checkDistinctElements = shuffleCards.shuffleCardsToPlayers(numberOfPlayers);
		assertEquals(52-(52%Integer.parseInt(numberOfPlayers)), checkDistinctElements);
		
	}
	
	/*To check if the number of players is less than 1 or greater than 53*/ 
	@Test
	public void testInvalidNumber() throws Exception {
		numberOfPlayers = testDataList.get(3);
		checkDistinctElements = shuffleCards.shuffleCardsToPlayers(numberOfPlayers);
			assertEquals(-1, checkDistinctElements);
	}
	
	/*To check if negative number of players won't work*/
	@Test
	public void testNegativeNumber() throws Exception {
		numberOfPlayers = testDataList.get(4);
		checkDistinctElements = shuffleCards.shuffleCardsToPlayers(numberOfPlayers);
			assertEquals(-1, checkDistinctElements);
	}	
	
	/*To check if the program throws error if a String is given as the number of players*/ 
	@Test
	public void testString() throws Exception {
		numberOfPlayers = testDataList.get(5);
		checkDistinctElements = shuffleCards.shuffleCardsToPlayers(numberOfPlayers);
			assertEquals(-2, checkDistinctElements);
	}
	
	/*To check if the program throws error if a special character is given as the number of players*/ 
	@Test
	public void testSpecialCharacters() throws Exception {
		numberOfPlayers = testDataList.get(6);
		checkDistinctElements = shuffleCards.shuffleCardsToPlayers(numberOfPlayers);
			assertEquals(-2, checkDistinctElements);
	}
		
	/*To check if the program throws error if a decimal number is given as the number of players*/ 
	@Test
	public void testDecimalNumber() throws Exception {
		numberOfPlayers = testDataList.get(7);
		checkDistinctElements = shuffleCards.shuffleCardsToPlayers(numberOfPlayers);
			assertEquals(-2, checkDistinctElements);
	}
	
	/*To check if the total number of cards is 52*/
	@Test
	public void test52Cards() throws Exception {
		numberOfPlayers = testDataList.get(9);
		checkDistinctElements = shuffleCards.shuffleCardsToPlayers(numberOfPlayers);
			assertEquals(52, checkDistinctElements);
	}
	
}
