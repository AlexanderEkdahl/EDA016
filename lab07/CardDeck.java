import se.lth.cs.ptdc.cardGames.Card;
import java.util.Random;

public class CardDeck {
	private Card[] cards;
	private int current;
	private static Random rand = new Random();
	
	public CardDeck() {
		cards = new Card[52];
		current = 0;
		for(int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
			for(int rank = 1; rank < 14; rank++) {
				cards[current] = new Card(suit, rank);
				current++;
			}
		}
	}
	
	public void shuffle() {
		for(int i = 51; i > 0; i--) {
			int n = rand.nextInt(i+1);
			Card c = cards[n];
			cards[n] = cards[i];
			cards[i] = c;
		}
		current = 51;
	}
	
	public boolean moreCards() {
		return (current > 0);
	}
	
	public Card getCard() {
		current--;
		return cards[current];
	}
}
