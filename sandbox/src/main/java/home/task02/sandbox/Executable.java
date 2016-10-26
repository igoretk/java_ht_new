package home.task02.sandbox;

public class Executable {
  public static void main(String[] args) {

    Point point1 = new Point(0, 0);
    Point point2 = new Point(3, 4);
    double result = point1.distance(point2);
    System.out.println("Растояние между точками point1=[" + point1.x + "," + point1.y + "]" +
            " и point2=[" + point2.x + "," + point2.y + "] равно: " + result);
    }
}