public class Complex {
  private double re;
  private double im;

  Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  double getRe() {
    return re;
  }

  double getIm() {
    return im;
  }

  double getAbs2() {
    return Math.pow(re, 2) + Math.pow(im, 2);
  }

  void add(Complex c) {
    im += c.getIm();
    re += c.getRe();
  }

  void mul(Complex c) {
    double real = getRe() * c.getRe() - getIm() * c.getIm();
    im = getRe() * c.getIm() + getIm() * c.getRe();
    re = real;
  }

}
