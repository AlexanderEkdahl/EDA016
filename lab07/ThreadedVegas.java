import se.lth.cs.ptdc.cardGames.Card;

class VegasThread extends Thread {
	volatile int failed = 0;
	volatile int iterations = 0;
	volatile boolean finished = false;

	public void run() {
		CardDeck deck = new CardDeck();

		while (!finished) {
			int n = 0;
			deck.shuffle();

			while(deck.moreCards()) {
				n = (n + 1) % 3;
				if(deck.getCard().getRank() == n+1) {
					failed++;
					break;
				}
			}

			iterations++;
		}
	}

	public int getResult() {
		return failed;
	}

	public int getIterations() {
		return iterations;
	}

	public void kill() {
		finished = true;
	}
}

class ThreadedVegas {
	static final int ITERATIONS = 10000000;
	static final int THREADSN = 2;

	public static void main(String args[]) {
		VegasThread[] threads = new VegasThread[THREADSN];

		for(int i = 0; i < THREADSN; i++) {
			threads[i] = new VegasThread();
			threads[i].start();
		}

		int failed = 0;
		int iterations = 0;

		try  {
			while (true) {
				for(int i = 0; i < THREADSN;i++) {
					failed += threads[i].getResult();
					iterations += threads[i].getIterations();
				}

				if(iterations > ITERATIONS) {
					System.out.println((double)(iterations-failed)/iterations);
					for(int i = 0; i < THREADSN; i++)
						threads[i].kill();

					break;
				}

				Thread.sleep(10);
			}
		}
		catch ( InterruptedException e ) { }
	}
}
