import se.lth.cs.ptdc.fractal.MandelbrotGUI;

public class Mandelbrot {
  public static void main(String[] args) {
    MandelbrotGUI gui = new MandelbrotGUI();
    Generator g = new Generator();

    while (true) {
      switch (gui.getCommand()) {
      case MandelbrotGUI.RENDER:
        g.render(gui);
        break;
      case MandelbrotGUI.RESET:
        gui.resetPlane();
        gui.clearPlane();
        break;
      case MandelbrotGUI.ZOOM:
        g.render(gui);
        break;
      case MandelbrotGUI.QUIT:
        System.exit(0);
      }
    }
  }
}
