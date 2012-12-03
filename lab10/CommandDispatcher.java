import se.lth.cs.ptdc.window.SimpleWindow;
import se.lth.cs.ptdc.shapes.Shape;

public class CommandDispatcher {
	private SimpleWindow w;
	private ShapeList shapes;

	public CommandDispatcher(SimpleWindow w, ShapeList shapes) {
		this.w = w;
		this.shapes = shapes;
	}

	public void mainLoop() {
		while(true) {
			w.waitForEvent();
			Shape s = shapes.findHit(w.getMouseX(), w.getMouseY());
			if(s != null) {
				w.waitForEvent();
				s.moveToAndDraw(w, w.getMouseX(), w.getMouseY());
			}
		}
	}
}
