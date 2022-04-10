import java.util.Arrays;
import java.util.Scanner;
public class MonthsNumber {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean leap = true;
		int year = 0;
		String month = " ";
		String[] month_list = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."}; 
		while (true) {
			System.out.println("Enter the month");
			month = keyboard.nextLine();
			if (!Arrays.asList(month_list).contains(month)) {
				System.out.println("Invalid month!");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("Enter the year");
			String syear = keyboard.nextLine();
			try {
				year = Integer.parseInt(syear);
				break;
			}
			catch (Exception e) {
				System.out.println("Invalid year!");
				continue;
			}
		} 
		if (year % 100 == 0 && year % 400 != 0) {
			leap = false;
		} else {
			leap = true;
		}
		if (month.length() == 1) {
			int imonth = Integer.parseInt(month);
			if (imonth == 4 || imonth == 6 || imonth == 9 || imonth == 11) {
				System.out.println("30");
			} else if (imonth == 2) {
				if (leap == true) {
					System.out.println("29");
				} else {
					System.out.println("28");
				} 
			} else {
				System.out.println("31");
			}
		} else if (month.length() == 3) {
			if (month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov")) {
				System.out.println("30");
			} else if (month.equals("Feb")) {
				if (leap == true) {
					System.out.println("29");
				} else {
					System.out.println("28");
				} 
			} else {
				System.out.println("31");
			}
		} else {
			if (month.equals("Apr.") || month.equals("Jun.") || month.equals("Sep.") || month.equals("Nov.")) {
				System.out.println("30");
			} else if (month.equals("Feb.")) {
				if (leap == true) {
					System.out.println("29");
				} else {
					System.out.println("28");
				} 
			} else {
				System.out.println("31");
			}
		}
	}
}
