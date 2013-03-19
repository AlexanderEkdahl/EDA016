import se.lth.cs.ptdc.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w;
	private double x;
	private double y;
	private boolean pen;
	private double direction = (Math.PI / 2);

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x,y med pennan lyft och huvudet pekande rakt uppåt
	 * i fönstret (i negativ y-riktning)
	 */
	public Turtle(SimpleWindow w, double x, double y) {
		this.w = w;
		this.x = x;
		this.y = y;
	}

	/** Sänker pennan */
	public void penDown() {
		pen = true;
	}

	/** Lyfter pennan */
	public void penUp() {
		pen = false;
	}

	/** Går rakt framåt n pixlar i den riktning som huvudet pekar */
	public void forward(int n) {
		if (pen)
			w.moveTo((int) Math.round(x), (int) Math.round(y));
		x += n * Math.cos(direction);
		y -= n * Math.sin(direction);
		if (pen)
			w.lineTo((int) Math.round(x), (int) Math.round(y));
	}

	/** Vrider beta grader åt vänster runt pennan */
	public void left(int beta) {
		this.direction += beta * (Math.PI / 180);
	}

	/**
	 * Går till punkten newX,newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte
	 */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga */
	public void turnNorth() {
		direction = Math.PI / 2;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position */
	public int getX() {
		return (int) x;
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position */
	public int getY() {
		return (int) y;
	}

	/** Tar reda på sköldpaddans riktning, i grader från positiv x-led */
	public int getDirection() {
		return (int) Math.toDegrees(direction);

	}
}