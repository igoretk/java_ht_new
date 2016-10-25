package home.task02.sandbox;

public class Executable {
  public static void main(String[] args) {

    Point point = new Point(3, 5, 2, 8);
    double result = point.distance();
    System.out.println("Расстояние между двумя точками A с координатами x1="
            + point.x1 + " и x2=" + point.x2 +
            " и B c координатами y1=" + point.y1 + " и y2=" + point.y2 +
            " на плоскости равно: " + result);
  }
}
