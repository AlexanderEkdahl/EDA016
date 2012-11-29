import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class ContrastFilter extends ImageFilter {

	Color[] grayLevels;

	/** skapa ett filterobjekt med namnet name */
	public ContrastFilter(String name) {
		super(name);

		grayLevels = new Color[256];
		for(int i = 0; i < 256; i++)
		{
			grayLevels[i] = new Color(i,i,i);
		}
	}

	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];

		short[][] intensity = new short[height][width];
		int[] histogram = new int[256];
		intensity = computeIntensity(inPixels);

		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				histogram[intensity[i][j]]++;
			}
		}

		int lowCut = 0;
		int highCut = 0;
		boolean doneLow = false;
		boolean doneHigh = false;

		double goal = paramValue/100 * height * width;
		for (int i = 0, sumLow = 0, sumHigh = 0; i < 256; i++) {
			sumLow += histogram[i];
			sumHigh += histogram[255-i];
			if((goal <= sumLow) && !doneLow)
			{
				lowCut = i;
				doneLow = true;
			}
			if((goal <= sumHigh) && !doneHigh)
			{
				highCut = 255-i;
				doneHigh = true;
			}

			if(doneLow && doneHigh)
				break;
		}
		
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				if(intensity[i][j] < lowCut)
					outPixels[i][j] = grayLevels[0];
				else if(intensity[i][j] > highCut)
					outPixels[i][j] = grayLevels[255];
				else {
					try {
						outPixels[i][j] = grayLevels[255*(intensity[i][j] - lowCut) / (highCut - lowCut)];
					} catch (java.lang.ArithmeticException e) {
						outPixels[i][j] = new Color(255,0,9);
					}
				}
			}
		}

		return outPixels;
	}
}
