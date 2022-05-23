package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class SystemFirstDegree {
  public static void main (String[] args) {
    String stra11, stra12, strb1, stra21, stra22, strb2;
    double a11, a12, b1, a21, a22, b2, D;
    stra11 = JOptionPane.showInputDialog(null, "Input number a11");
    a11 = Double.parseDouble(stra11);
    stra12 = JOptionPane.showInputDialog(null, "Input number a12");
    a12 = Double.parseDouble(stra12);
    strb1 = JOptionPane.showInputDialog(null, "Input number b1");
    b1 = Double.parseDouble(strb1);
    stra21 = JOptionPane.showInputDialog(null, "Input number a21");
    a21 = Double.parseDouble(stra21);
    stra22 = JOptionPane.showInputDialog(null, "Input number a22");
    a22 = Double.parseDouble(stra22);
    strb2 = JOptionPane.showInputDialog(null, "Input number b2");
    b2 = Double.parseDouble(strb2);
    D = a11*a22 - a21*a12;
    if (D == 0) {
      if (b1*a22 == b2*a21) {
        System.out.println("System has infinite solutions.");
      } else {
        System.out.println("System has no solution.");
      }
    } else {
      System.out.println("Solution of the system are: x1 = " + ((b1*a22 - b2*a12) / D) + ", x2 = " + ((a11*b2 - a21*b1) / D));
    }
  }
}
