import se.lth.cs.ptdc.window.SimpleWindow;

public class RaceTrack {
	private int yStart;
	private int yFinish;
	private int xOffset;

	public RaceTrack(int yStart, int yFinish) {
		this.yStart = yStart;
		this.yFinish = yFinish;
		this.xOffset = yFinish;
	}

	public RaceTrack(int yStart, int yFinish, int xOffset) {
		this.yStart = yStart;
		this.yFinish = yFinish;
		this.xOffset = xOffset;
	}

	public void draw(SimpleWindow w) {
		w.moveTo(xOffset, yFinish);
		w.lineTo(w.getWidth() - xOffset, yFinish);
		w.moveTo(xOffset, yStart);
		w.lineTo(w.getWidth() - xOffset, yStart);
	}

	public boolean inGoal(Turtle t) {
		return t.getY() < yFinish;
	}

	public int getYStart() {
		return yStart;
	}
}
