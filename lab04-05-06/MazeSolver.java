import java.util.Scanner;
import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.ptdc.window.SimpleWindow;

public class MazeSolver {
	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
		Maze m = new Maze(scan.nextInt());
		SimpleWindow w = new SimpleWindow(600, 600, "MazeSolver");
		MazeTurtle t = new MazeTurtle(w, m.getXEntry(), m.getYEntry(), m);

		m.draw(w);
		t.walk();
	}
}
