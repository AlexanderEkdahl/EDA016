import java.util.Scanner;
import se.lth.cs.ptdc.square.Square;
import se.lth.cs.ptdc.window.SimpleWindow;

public class AnimatedSquare {
	public static void main(String[] args) {
		System.out.println("Skriv förminskning");
		Scanner scan = new Scanner(System.in);
		int dim = scan.nextInt();
		System.out.println("Skriv rotation");
		int rot = scan.nextInt();
		
		SimpleWindow w = new SimpleWindow(600, 600, "DrawManySquares");
		Square sq = new Square(300, 300, 200);
		
		while (sq.getSide() > 0) {
			sq.setSide(sq.getSide() - dim);
			sq.rotate(rot);
			sq.draw(w);
			SimpleWindow.delay(100);
			sq.erase(w);
		}
	}
}
