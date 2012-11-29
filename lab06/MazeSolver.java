import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.ptdc.window.SimpleWindow;

public class MazeSolver {
	public static void main(String[] args) {
		Maze m = new Maze(5);
		SimpleWindow w = new SimpleWindow(600, 600, "MazeSolver");
		MazeTurtle t = new MazeTurtle(w, m.getXEntry(), m.getYEntry(), m);

		m.draw(w);
		t.walk();
	}
}
