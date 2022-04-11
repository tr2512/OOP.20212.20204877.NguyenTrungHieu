import javax.swing.JOptionPane;
public class SumTwoNumbers {
  public static void main (String[] args) {
    String str1, str2;
    double num1, num2;
    str1 = JOptionPane.showInputDialog(null, "Input the first number");
    str2 = JOptionPane.showInputDialog(null, "Input the second number");
    num1 = Double.parseDouble(str1);
    num2 = Double.parseDouble(str2);
    System.out.println("Sum of two numbers are: " + (num1 + num2));
    System.out.println("Difference of two numbers are: " + (num1 - num2));
    System.out.println("Product of two numbers are: " + (num1 * num2));
    if (num2 == 0) {
      System.out.println("Quotient doesn't exist.");
    } else {
    System.out.println("Quotient of two numbers are: " + (num1 / num2));
    }
  }
}
