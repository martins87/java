import java.util.*; 
import java.io.*;

class Factorial {  

  public static double combination(double n, double p) {
    return factorial(n) / (factorial(n - p) * factorial(p));
  }

  public static double arrangement(double n, double p) {
    return factorial(n) / factorial(n - p);
  }

  public static double factorial(double n) {
    double num = n;

    for(double i = num; i > 1; i--) {
      System.out.println("i = " + i);
      num *= i - 1;
    }

    return num;
  }

  public static void main (String[] args) {  
    System.out.print("Try me out!"); 
  }   
  
}
