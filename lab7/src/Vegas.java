import se.lth.cs.ptdc.cardGames.Card;

public class Vegas {
	public static void main(String[] args) {
		int failed = 0;
		int iterations = 10000000;

		for(int i = 0; i < iterations; i++) {
			CardDeck deck = new CardDeck();
			int n = 0;
			deck.shuffle();
			while(deck.moreCards()) {
				n = (n+1) % 3;
				if(deck.getCard().getRank() == n+1) {
					failed++;
					break;
				}
			}
		}
		
		System.out.println((double)(iterations-failed)/iterations);
	}
}
