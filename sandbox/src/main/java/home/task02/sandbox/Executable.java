package home.task02.sandbox;

public class Executable {
  public static void main(String[] args) {

    Point pointA = new Point();
    Point pointB = new Point();
    pointA.x1 = 3;
    pointA.x2 = 5;
    pointB.y1 = 2;
    pointB.y2 = 3;
    double result = distance(pointA, pointB);
    System.out.println("Расстояние между двумя точками A с координатами x1="
            + pointA.x1 + " и x2=" + pointA.x2 +
            " и B c координатами y1=" + pointB.y1 + " и y2=" + pointB.y2 +
            " на плоскости равно: " + result);
  }

  public static double distance(Point pointA, Point pointB) {
    double temp1 = (pointA.x2 - pointA.x1) * (pointA.x2 - pointA.x1); // для хранения части формулы (x2 - x1)^2
    double temp2 = (pointB.y2 - pointB.y1) * (pointB.y2 - pointB.y1); // для хранения части формулы (y2 - y1)^2
    return Math.sqrt(temp1 + temp2);
  }
}
