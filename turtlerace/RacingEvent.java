import java.util.Random;
import se.lth.cs.ptdc.window.SimpleWindow;

public class RacingEvent {
	private RaceTrack track;
	private Turtle t1;
	private Turtle t2;
	private int stepsize = 2;
	private int delay = 10;

	public RacingEvent(RaceTrack track, Turtle t1, Turtle t2) {
		this.track = track;
		this.t1 = t1;
		this.t2 = t2;
	}

	public RacingEvent(RaceTrack track, Turtle t1, Turtle t2, int stepsize,
			int delay) {
		this.track = track;
		this.t1 = t1;
		this.t2 = t2;
		this.stepsize = stepsize;
		this.delay = delay;
	}

	public void start() {
		Random rand = new Random();

		t1.penDown();
		t2.penDown();

		while (!(track.inGoal(t1) || track.inGoal(t2))) {
			t1.forward(rand.nextInt(stepsize));
			t2.forward(rand.nextInt(stepsize));
			SimpleWindow.delay(delay);
		}
	}
}
