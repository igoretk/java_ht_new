package ru.stqa.java_ht_new.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTests {
  @Test
  public void areaTest() {
    Rectangle r = new Rectangle(3, 4);
    Assert.assertEquals(r.areaRectangle(), 12.0);
  }


}
