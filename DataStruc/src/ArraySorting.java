import java.util.Scanner;

public class ArraySorting {

	public static void main(String[] args) {
		// Code to enable the user to input values in Array
		Scanner input = new Scanner(System.in);

		// Variable for inputting Values in Array
		int arrNum = input.nextInt();
		// Variable for Array
		int arr[] = new int[arrNum];
		// Variable for the length of Array
		int arrLeng = arr.length;

		// Print Number of index text
		System.out.print("Input Number of Index: ");

		// Input Array Values
		for (int i = 0; i < arrLeng; i++) {
			System.out.print("Input Array " + i + ": ");
			;
			arr[i] = input.nextInt();
		}
		// Print Natural order of Code
		System.out.print("\nNatural Order: ");
		for (int i : arr)
			System.out.print(i + " ");

		// Function of Ascending
		for (int i = 0; i < arrLeng; i++) {
			for (int j = 0; j < arrLeng - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
		// Print Ascending Order
		System.out.print("\nAscending Order: ");
		for (int i = 0; i < arrLeng; i++) {
			System.out.print(arr[i] + " ");
		}
		// Function of Descending Order
		for (int i = 0; i < arrLeng; i++) {
			for (int j = 0; j < arrLeng - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
		// Print Descending Order
		System.out.print("\nDescending Order: ");
		for (int j = 0; j < arrLeng; j++) {
			System.out.print(arr[j] + " ");
		}
		// Function and Print of Highest Number in Array
		System.out.print("\nHighest: " + arr[arrLeng - arrLeng]);
		// Function and Print of Lowest Number in Array
		System.out.println("\nLowest: " + arr[arrLeng - 1]);

	}

}