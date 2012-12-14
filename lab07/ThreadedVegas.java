import java.util.ArrayList;
import se.lth.cs.ptdc.cardGames.Card;

class VegasThread extends Thread {
	int failed = 0;
	int iterations = 0;

	public void run() {
		CardDeck deck = new CardDeck();

		for(int i = 0; i < ThreadedVegas.iterations; i++) {
                        int n = 0;
			iterations++;
                        deck.shuffle();
                        while(deck.moreCards()) {
                                n = (n+1) % 3;
                                if(deck.getCard().getRank() == n+1) {
                                        failed++;
                                        break;
                                }
                        }
                }
	}
	public synchronized int getResult() {
		return failed;
	}

	public synchronized int getIterations() {
		return iterations;
	}
}

class ThreadedVegas extends Thread {
	static final int iterations = 10000000;
	static final int nthreads = 2;
	VegasThread[] threads = new VegasThread[nthreads];

	ThreadedVegas(VegasThread[] threads) {
		this.threads = threads;
	}

   	public void run() {
		try  {
			while (true) {
				int failedtotal = 0;
				int iterationstotal = 0;

				for(int i = 0; i < nthreads;i++) {
					failedtotal = threads[i].getResult();
					iterationstotal = threads[i].getIterations();
				}

				System.out.println(iterationstotal);
				System.out.println((double)(iterationstotal-failedtotal)/iterationstotal);

				sleep(500);
			}
		}
		catch( InterruptedException e ) { }
	}

	public static void main(String args[]) {
		VegasThread[] threads = new VegasThread[nthreads];

		for(int i = 0; i < nthreads;i++) {
			threads[i] = new VegasThread();
			threads[i].start();
		}

		new ThreadedVegas(threads).start();
	}
}
