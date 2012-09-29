import se.lth.cs.ptdc.window.SimpleWindow;
import se.lth.cs.ptdc.square.Square;

public class StarCraft {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "StarCraft");
		Square sq = new Square(300, 300, 100);

		while (true) {
			w.waitForEvent();

			if (w.getEventType() == SimpleWindow.MOUSE_EVENT) {
				int sx = (w.getMouseX() - sq.getX()) / 10;
				int sy = (w.getMouseY() - sq.getY()) / 10;

				for (int i = 0; i < 10; i++) {
					sq.move(sx, sy);
					sq.draw(w);
				}
			} else {
				switch (w.getKey()) {
				case 'r':
					w.setLineColor(java.awt.Color.RED);
					break;
				default:
					w.setLineColor(java.awt.Color.BLACK);
				}
			}
		}
	}
}
