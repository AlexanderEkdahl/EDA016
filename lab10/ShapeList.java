import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;
import java.util.ArrayList;

public class ShapeList {
	private ArrayList<Shape> shapes;
	
	public ShapeList() {
		shapes = new ArrayList<Shape>();
	}

	/**
	 * Lägger in en figur i listan.
	 * 
	 * @param s
	 *            figuren som ska läggas in i listan
	 */
	public void insert(Shape s) {
		shapes.add(s);
	}

	/**
	 * Ritar upp figurerna i listan.
	 * 
	 * @param w
	 *            fönstret där figurerna ritas
	 */
	public void draw(SimpleWindow w) {
		for (Shape s : shapes) {
			s.draw(w);
		}
	}

	/**
	 * Tar reda på en figur som ligger nära punkten xc,yc. Om flera figurer
	 * ligger nära så returneras den första som hittas, om ingen figur ligger
	 * nära returneras null.
	 * 
	 * @param xc
	 *            x-koordinaten
	 * @param yc
	 *            y-koordinaten
	 */
	public Shape findHit(int xc, int yc) {
		for (Shape s : shapes) {
			if(s.near(xc, yc))
				return s;
		}
		return null;
	}
}
