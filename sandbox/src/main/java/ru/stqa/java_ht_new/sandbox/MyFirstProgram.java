package ru.stqa.java_ht_new.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
      hello("world");
      hello("user");
      hello("Igor");

      double l = 5;
      double a = 6;
      double b = 8;
      System.out.println("Площадь квадрата со стороной " + l + " равна " + areaSquare(l));
      System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + areaRectangle(a, b));

    }
    public static void hello(String somebody) {

      System.out.println("hello " + somebody);
    }

    public static double areaSquare(double l) {
      return l * l;
    }

    public static double areaRectangle(double a, double b) {
      return a * b;
    }

}