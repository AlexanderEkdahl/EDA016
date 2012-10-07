import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class ContrastFilter extends ImageFilter {
	/** skapa ett filterobjekt med namnet name */
	public ContrastFilter(String name) {
		super(name);
	}
	
	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		
		short[][] intensity = computeIntensity(inPixels);
		int[] histogram = new int[256];
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				histogram[(int)intensity[i][j]]++;
			}
		}
		
		int pixels = (int)Math.round(paramValue / 100 * width * height);
		
		int lowCut = 0;
		int sum = histogram[0];
		
		while(sum < pixels) {
			lowCut++;
			sum += histogram[lowCut];
		}
		
		int highCut = 255;
		sum = histogram[255];
		
		while(sum < pixels) {
			highCut--;
			sum += histogram[highCut];
		}
		
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				int newIntensity = 0;
				if(intensity[i][j] > highCut) {
					newIntensity = 255;
				}
				else {
					newIntensity = (int)Math.round(255 * (double)((intensity[i][j] - lowCut) / (highCut - lowCut)));
				}
				
				try {
					outPixels[i][j] = new Color(newIntensity, newIntensity, newIntensity);
				}
				catch(Exception e) {
					System.out.println(newIntensity);
				}
			}
		}
		return outPixels;
	}
}
