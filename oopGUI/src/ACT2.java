import java.util.*;

public class ACT2 {

	public static void main(String[] args) {
		System.out.println("High Low Game\n");
		Scanner input = new Scanner(System.in);

		int x = ((int) (Math.random() * 25));
		int y = 0;
		System.out.println(x);

		for (int i = 1; i < 1000 ; i++) {
			System.out.print("\nEnter number [1-25]: ");
			int n1 = input.nextInt();

			if (n1 > 25) {
				System.out.println("Out of Range!");
			} else if (n1 > x) {
				System.out.println("Number is too high!");

			} else if (n1 == 0) {
				System.out.println("Out of Range!");

			} else if (n1 < x) {
				System.out.println("Number is too low!");
			} else if (n1 == x) {
				System.out.println("You Got it Right!");
				System.out.println(i + "attempt(s) made");
				System.exit(0);
			}
		}
	}
}