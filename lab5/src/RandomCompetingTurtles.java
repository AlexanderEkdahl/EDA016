import java.util.Random;
import se.lth.cs.ptdc.window.SimpleWindow;

public class RandomCompetingTurtles {
	double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		Turtle t1 = new ColorTurtle(w, 250, 250, java.awt.Color.RED);
		Turtle t2 = new ColorTurtle(w, 350, 350, java.awt.Color.BLUE);

		t1.penDown();
		t2.penDown();
		while(Math.sqrt(Math.pow(t2.getX()-t1.getX(),2) + Math.pow(t2.getY()-t1.getY(),2)) >= 50) {
			t1.forward(rand.nextInt(10)+1);
			t1.left(rand.nextInt(360)-180);
			t2.forward(rand.nextInt(10)+1);
			t2.left(rand.nextInt(360)-180);
			SimpleWindow.delay(10);
		}
	}
}
