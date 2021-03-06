import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Circle extends Shape {
	protected int r;

	public Circle(int x, int y, int r) {
		super(x, y);
		this.r = r;
	}

	private void setPixel(int x, int y, SimpleWindow w) {
		w.moveTo(x, y);
		w.lineTo(x, y);
	}

	private void circlePoints(int cx, int cy, int x, int y, SimpleWindow w)
	{
		if (x == 0) {
			setPixel(cx, cy + y, w);
			setPixel(cx, cy - y, w);
			setPixel(cx + y, cy, w);
			setPixel(cx - y, cy, w);
		} else
		if (x == y) {
			setPixel(cx + x, cy + y, w);
			setPixel(cx - x, cy + y, w);
			setPixel(cx + x, cy - y, w);
			setPixel(cx - x, cy - y, w);
		} else
		if (x < y) {
			setPixel(cx + x, cy + y, w);
			setPixel(cx - x, cy + y, w);
			setPixel(cx + x, cy - y, w);
			setPixel(cx - x, cy - y, w);
			setPixel(cx + y, cy + x, w);
			setPixel(cx - y, cy + x, w);
			setPixel(cx + y, cy - x, w);
			setPixel(cx - y, cy - x, w);
		}
	}

	public void draw(SimpleWindow w) {
		int x = 0;
		int y = r;
		int p = (5 - r*4)/4;

		circlePoints(this.x, this.y, x, y, w);
		while (x < y) {
			x++;
			if (p < 0) {
				p += 2*x+1;
			} else {
				y--;
				p += 2*(x-y)+1;
			}
			circlePoints(this.x, this.y, x, y, w);
		}
	}
}
