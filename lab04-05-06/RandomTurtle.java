import java.util.Random;
import se.lth.cs.ptdc.window.SimpleWindow;

public class RandomTurtle {
	public static void main(String[] args) {
		Random rand = new Random();
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		Turtle t = new Turtle(w, 300, 300);

		t.penDown();
		for (int i = 0; i < 1000; i++) {
			t.forward(rand.nextInt(10)+1);
			t.left(rand.nextInt(360)-180);
		}
	}
}
