package home.task03.sandbox;

import home.task02.sandbox.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistanceTests {

  @Test // passed test
  public void distanceTestOne() {
    Point p = new Point(2, 6, 3, 3);
    double temp = p.distance(); // мини-блок для самопроверки
    System.out.println("Вычисляем расстояние для самопроверки: " + temp);
    Assert.assertEquals(p.distance(), 4.0);

  }
  @Test // failed test
  public void distanceTestTwo() {
    Point p = new Point(2, 6, 3, 3);
    double temp = p.distance(); // мини-блок для самопроверки
    System.out.println("Вычисляем расстояние для самопроверки: " + temp);
    Assert.assertEquals(p.distance(), 3.0);

  }
  @Test // failed test with a msg
  public void distanceTestThree() {
    Point p = new Point(2, 6, 3, 3);
    double temp = p.distance(); // мини-блок для самопроверки
    System.out.println("Вычисляем расстояние для самопроверки: "+ temp);
    Assert.assertEquals(p.distance(), 5, "ALARM");

  }
}
