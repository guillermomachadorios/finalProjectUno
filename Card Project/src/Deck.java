import java.util.ArrayList;
import java.util.Collections;

public class Deck
	{
	static ArrayList<Card> deck = new ArrayList<Card>();
	
	public static void fillDeck()
		{
		deck.add(new Card("1", "Red", false));
		deck.add(new Card("1", "Blue", false));
		deck.add(new Card("1", "Green", false));
		deck.add(new Card("1", "Yellow", false));
		deck.add(new Card("2", "Red", false));
		deck.add(new Card("2", "Blue", false));
		deck.add(new Card("2", "Green", false));
		deck.add(new Card("2", "Yellow", false));
		deck.add(new Card("3", "Red", false));
		deck.add(new Card("3", "Blue", false));
		deck.add(new Card("3", "Green", false));
		deck.add(new Card("3", "Yellow", false));
		deck.add(new Card("4", "Red", false));
		deck.add(new Card("4", "Blue", false));
		deck.add(new Card("4", "Green", false));
		deck.add(new Card("4", "Yellow", false));
		deck.add(new Card("5", "Red", false));
		deck.add(new Card("5", "Blue", false));
		deck.add(new Card("5", "Green", false));
		deck.add(new Card("5", "Yellow", false));
		deck.add(new Card("6", "Red", false));
		deck.add(new Card("6", "Blue", false));
		deck.add(new Card("6", "Green", false));
		deck.add(new Card("6", "Yellow", false));
		deck.add(new Card("7", "Red", false));
		deck.add(new Card("7", "Blue", false));
		deck.add(new Card("7", "Green", false));
		deck.add(new Card("7", "Yellow", false));
		deck.add(new Card("8", "Red", false));
		deck.add(new Card("8", "Blue", false));
		deck.add(new Card("8", "Green", false));
		deck.add(new Card("8", "Yellow", false));
		deck.add(new Card("9", "Red", false));
		deck.add(new Card("9", "Blue", false));
		deck.add(new Card("9", "Green", false));
		deck.add(new Card("9", "Yellow", false));
		deck.add(new Card("0", "Red", false));
		deck.add(new Card("0", "Blue", false));
		deck.add(new Card("0", "Green", false));
		deck.add(new Card("0", "Yellow", false));
		}
	
	public static void shuffle()
		{
		Collections.shuffle(deck);
		}
	}