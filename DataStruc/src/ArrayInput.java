import java.util.Scanner;

public class ArrayInput {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter Number of Array: ");
		int arrNum = input.nextInt();
		int arr[] = new int[arrNum];

		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter Array Value[" + i + "]: ");
			arr[i] = input.nextInt();

		}
		System.out.print("Natural Order:");
		for (int i : arr)
			System.out.print(" " + i + " ");

	}
}
