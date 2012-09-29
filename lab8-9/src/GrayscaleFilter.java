import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class GrayscaleFilter extends ImageFilter {
	/** skapa ett filterobjekt med namnet name */
	public GrayscaleFilter(String name) {
		super(name);
	}

	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		short[][] intensity = computeIntensity(inPixels);
		Color[][] outPixels = new Color[height][width];
		Color[] graypixels = new Color[256];

		for(int n = 0; n < 256; n++) graypixels[n] = new Color(n, n, n);

		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				outPixels[i][j] = graypixels[intensity[i][j]];
			}
		}
		return outPixels;
	}
}
