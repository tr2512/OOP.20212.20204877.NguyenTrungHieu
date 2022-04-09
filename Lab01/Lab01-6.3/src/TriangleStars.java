import java.util.Scanner;
public class TriangleStars {
	public static void main (String[] args) {
		int v;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter n");
		int n = keyboard.nextInt();
		for (int i = 0; i < n; i++) {
			v = (2*n - 1 - (2*i + 1)) / 2;
			System.out.println(" ".repeat(v) + "*".repeat(2*i + 1) + " ".repeat(v));
		}
	}
}

