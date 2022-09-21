import java.util.*;

public class ACT1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Highest and Lowest\n");
		System.out.print("Enter First Number:");
		int num1 = input.nextInt();

		System.out.print("Enter Second Number:");
		int num2 = input.nextInt();

		System.out.print("Enter Third Number:");
		int num3 = input.nextInt();

		if (num1 > num2 && num1 > num3) {

			System.out.println("\nThe 1st number is the highest:" + num1);

		} else if (num2 > num1 && num2 > num3) {
			System.out.println("\nThe 2nd number is the highest:" + num2);

		} else {
			System.out.println("\nThe 3rd number is the highest:" + num3);

		}

		if (num1 < num2 && num1 < num3) {

			System.out.println("\nThe 1st number is the lowest:" + num1);

		} else if (num2 < num1 && num2 < num3) {
			System.out.println("\nThe 2nd number is the lowest:" + num2);

		} else {
			System.out.println("\nThe 3rd number is the lowest:" + num3);

		}
	}
}
