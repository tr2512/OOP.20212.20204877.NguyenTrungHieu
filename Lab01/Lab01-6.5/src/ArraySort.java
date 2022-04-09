import java.util.Arrays;
import java.util.Scanner;
public class ArraySort {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner (System.in);
		double sum = 0;
		System.out.println("Type the array: ");
		String strarr = keyboard.nextLine();
		String[] array = strarr.split(" ");
		double[] intarr = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			intarr[i] = Double.parseDouble(array[i]);
			sum += intarr[i];
		}
		Arrays.sort(intarr);
		System.out.println("The sorted array: " + Arrays.toString(intarr));
		System.out.println("The sum of values in the array is: " + sum);
		System.out.println("The average of values in the array is: " + (sum / array.length));
	}
}
