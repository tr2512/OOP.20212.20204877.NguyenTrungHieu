//This program add 2 constant matrix array1 and array2 together
import java.util.Arrays;
public class MatrixAddition {
	public static void main (String[] args) {
		int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] array2 = {{7, 8, 9},{10, 11, 12}};
		int[][] sum = new int[array1.length][array1[0].length];
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[0].length; j ++) {
				sum[i][j] = array1[i][j] + array2[i][j];
			}		
		}
		System.out.println("The sum of 2 arrays:");
		for (int i = 0; i < array1.length; i++) {
			System.out.println(Arrays.toString(sum[i]));
		}
	}
}
