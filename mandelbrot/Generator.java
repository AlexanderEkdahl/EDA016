import java.awt.Color;
import se.lth.cs.ptdc.fractal.MandelbrotGUI;

public class Generator {
  static final int ITERATIONS = 255;
  Color[] hues;

  public Generator() {
    hues = new Color[ITERATIONS];

    for (int n = 0; n < ITERATIONS; n++)
      hues[n] = Color.getHSBColor((n * (360f / ITERATIONS))/360, 0.8f, 0.8f);
  }

  public void render(MandelbrotGUI gui) {
    gui.disableInput();
    int pxs = 1;

    switch (gui.getResolution()) {
    case MandelbrotGUI.RESOLUTION_HIGH:
      pxs = 3;
      break;
    case MandelbrotGUI.RESOLUTION_MEDIUM:
      pxs = 5;
      break;
    case MandelbrotGUI.RESOLUTION_LOW:
      pxs = 7;
      break;
    case MandelbrotGUI.RESOLUTION_VERY_LOW:
      pxs = 9;
      break;
    }

    Complex[][] complex = mesh(
        gui.getMinimumReal(), gui.getMaximumReal(),
        gui.getMinimumImag(), gui.getMaximumImag(),
        gui.getWidth(), gui.getHeight());
    Color[][] picture = new Color[gui.getHeight() / pxs + 1][gui.getWidth() / pxs + 1];

    for (int i = 0; i < gui.getHeight() / pxs; i++) {
      for (int j = 0; j < gui.getWidth() / pxs; j++) {
        Complex c = complex[pxs / 2 + i * pxs][pxs / 2 + j * pxs];
        Complex z = new Complex(0, 0);
        int n = 0;

        while(n < ITERATIONS - 1 && z.getAbs2() <= 4) {
          n++;
          z.mul(z);
          z.add(c);
        }

        switch(gui.getMode()) {
        case MandelbrotGUI.MODE_COLOR:
          if(n < ITERATIONS - 1) {
            picture[i][j] = hues[n];
          } else {
            picture[i][j] = hues[ITERATIONS - 1];
          }
        break;

        case MandelbrotGUI.MODE_BW:
          if(z.getAbs2() <= 4) {
            picture[i][j] = Color.black;
          } else {
            picture[i][j] = Color.white;
          }
        break;
        }
      }
    }

    gui.putData(picture, pxs, pxs);
    gui.enableInput();
  }

  private Complex[][] mesh(double minRe, double maxRe, double minIm, double maxIm, int width, int height) {
    Complex[][] complex = new Complex[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        complex[i][j] = new Complex(
            minRe + (-minRe + maxRe) / (width - 1) * j,
            maxIm - (-minIm + maxIm) / (height - 1) * i);
      }
    }
    return complex;
  }
}
