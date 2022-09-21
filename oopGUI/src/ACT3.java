import java.util.*;

public class ACT3 {

	public static void main(String[] args) {

		int[] num = { 10, 9, 7, 8, 9, 7, 8, 12 };
		int n1 = 0;
		int n2 = 0;
		int even = 0;
		int odd = 0;

		for (int i = 0; i < num.length; i++) {

			if (num[i] % 2 == 0) {
				n1 = even++ + 1;
			} else {
				n2 = odd++ + 1;
			}
		}
		System.out.println("Even: " + n1);
		System.out.println("Odd: " + n2);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}
}
