import se.lth.cs.ptdc.window.SimpleWindow;
import java.io.File;
import java.util.Scanner;

public class ShapeTest {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "ShapeTest");
		ShapeList shapes = new ShapeList();
		CommandDispatcher cd = new CommandDispatcher(w, shapes);
		File file = new File("shapedata.txt");

		try {
			Scanner scan = new Scanner(file);

			while(scan.hasNext()) {
				String s = scan.next();

				if(s.equals("S")) {
					shapes.insert(new Square(scan.nextInt(), scan.nextInt(), scan.nextInt()));
				}
				else if(s.equals("T")) {
					shapes.insert(new Triangle(scan.nextInt(), scan.nextInt(), scan.nextInt()));
				}
				else if(s.equals("C")) {
					shapes.insert(new Circle(scan.nextInt(), scan.nextInt(), scan.nextInt()));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		shapes.draw(w);

		cd.mainLoop();
	}
}
