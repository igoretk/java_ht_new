package ru.stqa.java_ht_new.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Igor");
    Square s = new Square(5);
    Rectangle r = new Rectangle(6, 8);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.areaSquare());
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.areaRectangle());

  }

  public static void hello(String somebody) {

    System.out.println("hello " + somebody);
  }


}