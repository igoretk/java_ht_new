package ru.stqa.java_ht_new.sandbox;

public class Rectangle {
  public double a;
  public double b;

  public Rectangle(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double areaRectangle() {
    return this.a * this.b;
  }
}
