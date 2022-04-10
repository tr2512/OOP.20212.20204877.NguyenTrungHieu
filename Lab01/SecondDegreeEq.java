import java.lang.Math;
import javax.swing.JOptionPane;

public class SecondDegreeEq {
  public static void main (String[] args){
    String stra, strb, strc;
    double a, b, c, delta;
    stra = JOptionPane.showInputDialog(null, "Input number a");
    a = Double.parseDouble(stra);
    strb = JOptionPane.showInputDialog(null, "Input number b");
    b = Double.parseDouble(strb);
    strc = JOptionPane.showInputDialog(null, "Input number c");
    c = Double.parseDouble(strc);
    delta = b*b - 4*a*c;
    if (a == 0) {
      if (b == 0) {
        System.out.println("The equation has no solution.");
      } else {
        System.out.println("The equation has one solution: " + (-c/b));
      }
    } else if (delta < 0) {
      System.out.println("The equation has no solution.");
    } else if (delta == 0) {
      System.out.println("The equation has one solution: " + (-b/(2*a)));
    } else {
      System.out.println("The equation has two solutions x1 = " + ((-b + Math.sqrt(delta))/(2*a)) + " x2 = " + ((-b - Math.sqrt(delta))/(2*a)));
    }
  }
}
