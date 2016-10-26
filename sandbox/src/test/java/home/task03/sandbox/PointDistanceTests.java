package home.task03.sandbox;

import home.task02.sandbox.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistanceTests {

  @Test ( priority = 1 ) // passed test with a msg
  public void distanceTestOne() {
    System.out.println("distanceTestOne");
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);
    double actualRes = p1.distance(p2);
    Assert.assertEquals(actualRes, 5.0);

  }
  @Test ( priority = 2 )// failed test
  public void distanceTestTwo() {
    System.out.println("distanceTestTwo");
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);
    double actualResult = p1.distance(p2);
    Assert.assertEquals(actualResult, 3.0);
  }
  @Test ( priority = 3 )// failed test with a msg
  public void distanceTestThree() {
    System.out.println("distanceTestThree");
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);
    double actualResult = p1.distance(p2);
    Assert.assertEquals(actualResult, 5, "FAIL");

  }
}
