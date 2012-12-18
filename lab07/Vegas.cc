#include <iostream>
#include <algorithm>

using namespace std;

#define ITERATIONS 10000000

enum { CLUB, DIAMOND, HEART, SPADE };

enum { ACE, TWO, THREE, FOUR, FIVE, SIX , SEVEN, EIGHT, NINE, TEN , JACK, QUEEN, KING };

struct Card {
  char suit, value;
};

class Deck {
    Card cards[52];
    char current;
  public:
    Deck() {
      current = 0;
      for(char suit = 0; suit <= SPADE; suit++) {
        for(char value = 0; value <= KING; value++) {
          cards[current].suit = suit;
          cards[current].value = value;
          current++;
        }
      }
    };

    void shuffle() {
      random_shuffle(cards, cards + 52);
      current = 52;
    };

    bool moreCards() {
      return (current > 0);
    };

    Card getCard() {
      current--;
      return cards[current];
    };
};

int main () {
  int failed = 0;
  Deck deck;

  srand( unsigned( time(NULL) ) );

  for(int i = 0; i < ITERATIONS; i++) {
    int n = 0;
    deck.shuffle();
    while(deck.moreCards()) {
      n = (n+1) % 3;
      if(deck.getCard().value == n) {
        failed++;
        break;
      }
    }
  }

  cout << ((double)ITERATIONS-failed)/ITERATIONS << endl;

  return 0;
}
