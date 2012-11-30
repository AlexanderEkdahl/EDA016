import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.ptdc.window.SimpleWindow;

public class MazeTurtle extends Turtle {
	private Maze m;

	public MazeTurtle(SimpleWindow w, int x, int y, Maze m) {
		super(w, x, y);
		this.m = m;
	}

	public void walk() {
		penDown();
		while(!m.atExit(getX(), getY())) {
			if(!m.wallAtLeft(getDirection(), getX(), getY())) {
				left(90);
			} else if(m.wallInFront(getDirection(), getX(), getY()) && m.wallAtLeft(getDirection(), getX(), getY())) {
				left(-90);

        if(m.wallInFront(getDirection(), getX(), getY()) && m.wallAtLeft(getDirection(), getX(), getY())) {
          left(-90);
        }
			}

			forward(1);
			SimpleWindow.delay(10);
		}
		penUp();
	}
}
