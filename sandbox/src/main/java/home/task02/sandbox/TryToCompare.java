package home.task02.sandbox;

public class TryToCompare {
  public static void main(String[] args) {
    String s1 = "";
    String s2 = null;
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    String s3 = s1;
    System.out.println("s3= " + s3);
  }
}
