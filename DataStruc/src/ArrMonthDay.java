import java.util.Scanner;

public class ArrMonthDay {
	public static void main(String[] args) {
		int month;
		int day;

		Scanner enter = new Scanner(System.in);

		String m[] = { "January", "Febuarary", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		String d[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

		System.out.println("Month: ");
		month = enter.nextInt();
		System.out.println("Day: ");
		day = enter.nextInt();
		System.out.println("\n" + "Result: " + "\n");

		for (int i = month; i <= month; i++)
			System.out.println(m[i - 1]);

		for (int k = day; k <= day; k++)
			System.out.println(d[k - 1]);

	}
}