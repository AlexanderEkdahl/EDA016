import java.util.Random;
import java.awt.Color;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Polygon {
	private static final int FEST = 1000;

	public static void main(String[] args) {
		Random rand = new Random();
		SimpleWindow w = new SimpleWindow(600, 600, "Polygon");
		double a1 = rand.nextDouble()*2*Math.PI;
		double a = a1;
		int d1 = rand.nextInt(300);
		int d = d1;

		w.moveTo((int)Math.round(Math.cos(a)*d)+300, (int)Math.round(Math.sin(a)*d)+300);

		for(int i = 0; i < FEST - 1; i++) {
			Color c = new Color(255-(int)Math.round((255.0/FEST)*i), 127, (int)Math.round((255.0/FEST)*i));
			w.setLineColor(c);
			a += (2*Math.PI)/FEST;
			d = rand.nextInt(300);
			w.lineTo((int)Math.round(Math.cos(a)*d)+300, (int)Math.round(Math.sin(a)*d)+300);
			SimpleWindow.delay(1);
		}

		w.lineTo((int)Math.round(Math.cos(a1)*d1)+300, (int)Math.round(Math.sin(a1)*d1)+300);
	}
}

