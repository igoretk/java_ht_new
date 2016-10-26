package ru.stqa.java_ht_new.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SquareTests {
  @Test
  public void testArea() {
    Square s = new Square(5);
    Assert.assertEquals(s.areaSquare(), 25.0);

  }
}
