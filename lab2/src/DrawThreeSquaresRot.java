import se.lth.cs.ptdc.window.SimpleWindow;
import se.lth.cs.ptdc.square.Square;

public class DrawThreeSquaresRot {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(300, 300, 200);
		sq.draw(w);
		sq.rotate(30);
		sq.draw(w);
		sq.rotate(30);
		sq.draw(w);
	}
}
