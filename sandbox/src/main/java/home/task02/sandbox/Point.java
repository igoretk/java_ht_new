package home.task02.sandbox;

public class Point{
  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

    public double distance(double x, double y) {
    double temp1 = (this.x - x)*(this.x - x);
    double temp2 = (this.y - y)*(this.y - y);
    return Math.sqrt(temp1 + temp2);
  }

  public double distance(Point p) {
    return distance(p.x, p.y);
  }
}