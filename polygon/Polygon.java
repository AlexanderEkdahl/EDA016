import java.util.Random;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Polygon {
	private static final int ITERATIONS = 100;

	public static void main(String[] args) {
		Random rand = new Random();
		SimpleWindow w = new SimpleWindow(600, 600, "Polygon");
		double a1 = rand.nextDouble()*2*Math.PI;
		double a = a1;
		int d1 = rand.nextInt(300);
		int d = d1;

		w.moveTo((int)Math.round(Math.cos(a)*d)+300, (int)Math.round(Math.sin(a)*d)+300);

		for(int i = 0; i < ITERATIONS - 1; i++) {
			a += (2*Math.PI)/ITERATIONS;
			d = rand.nextInt(300);
			w.lineTo((int)Math.round(Math.cos(a)*d)+300, (int)Math.round(Math.sin(a)*d)+300);
		}

		w.lineTo((int)Math.round(Math.cos(a1)*d1)+300, (int)Math.round(Math.sin(a1)*d1)+300);
	}
}

