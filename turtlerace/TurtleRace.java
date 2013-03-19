import java.util.Scanner;
import se.lth.cs.ptdc.window.SimpleWindow;

public class TurtleRace {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Skriv in storleken på ditt fönster");
		int size = scan.nextInt();

		SimpleWindow w = new SimpleWindow(size, size, "Turtle Race");
		RaceTrack track = new RaceTrack((int) Math.round(size * 0.9),
				(int) Math.round(size * 0.1));
		track.draw(w);

		Turtle t1 = new Turtle(w, (int) Math.round(w.getWidth() / 3),
				track.getYStart());
		Turtle t2 = new Turtle(w, (int) Math.round(w.getWidth() / 3 * 2),
				track.getYStart());
		RacingEvent event = new RacingEvent(track, t1, t2);

		while (true) {
			w.waitForEvent();
			if (w.getEventType() == SimpleWindow.MOUSE_EVENT)
				event.start();
		}
	}
}
