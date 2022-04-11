import javax.swing.JOptionPane;
public class FirstDegreeEq {
  public static void main (String[] args) {
    String stra, strb;
    double a, b;
    stra = JOptionPane.showInputDialog(null, "Input number a");
    a = Double.parseDouble(stra);
    strb = JOptionPane.showInputDialog(null, "Input number b");
    b = Double.parseDouble(strb);
    if (a == 0) {
      System.out.println("Equation has no solution");
    } else {
      System.out.println("Solution of the equation is: " + (-b / a));
    }
  }
}
