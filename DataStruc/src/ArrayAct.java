import java.util.Arrays;
import java.util.Scanner;

public class ArrayAct {
	static Scanner scanner = new Scanner(System.in);

	static void displayArray(int[] arrN) {
		for (int arr : arrN) {
			System.out.print(arr + " ");
		}
	}

	static void getValUser(int[] arrP) {
		for (int i = 0; i < arrP.length; i++) {
			System.out.print("Index" + "[" + i + "]" + ": ");
			arrP[i] = scanner.nextInt();
		}
	}

	public void arrayOrder(int[] arrP, int order) {
		Arrays.sort(arrP);

		if (order == 1) {
			for (int i = arrP.length - 1; i >= 0; i--) {
				System.out.print(arrP[i] + " ");
			}
		}
		if (order == 2) {
			for (int i = 0; i < arrP.length; i++) {
				System.out.print(arrP[i] + " ");
			}
		}

	}

	public void getIndex(int[] arrP, int index) {

		if (index < 0 || index >= arrP.length) {
			System.out.println("OUT OF BOUNDS");
		} else
			System.out.println("The value of Index[" + index + "]" + " is " + arrP[index]);
	}

	public static void main(String[] args) {
		var Obj = new ArrayAct();
		int len;
		System.out.println("------------------------------------------------------------");
		System.out.println(" Review on Class Method with Sort and Search Algorithms   ");
		System.out.print("------------------------------------------------------------");
		System.out.print("\nArray Length: ");
		len = scanner.nextInt();
		int[] arrN = new int[len];
		getValUser(arrN);
		System.out.println("------------------------------------------------------------");
		System.out.println("[1] Display Array Elements [4] Display Index Value");
		System.out.println("[2] Descending             [5] Exit ");
		System.out.println("[3] Ascending Order");
		System.out.println("------------------------------------------------------------");

		while (true) {
			System.out.print("\nSelect Transaction: ");
			int select = scanner.nextInt();
			if (select == 1) {
				System.out.println("\nDisplay Array Elements");
				displayArray(arrN);
				System.out.println("");
			} else if (select == 2) {
				System.out.println("\nDescending Order");
				Obj.arrayOrder(arrN, 1);
				System.out.println("");
			} else if (select == 3) {
				System.out.println("\nAscending Order");
				Obj.arrayOrder(arrN, 2);
				System.out.println("");
			} else if (select == 4) {
				System.out.print("\nDisplay Index Value: ");
				int index = scanner.nextInt();
				Obj.getIndex(arrN, index);
				System.out.println("");
			} else if (select == 5) {
				break;
			} else {
				System.out.print("Invalid selection!");
				System.out.println("");
			}

		}
		System.out.print("\nEnd of Program");

	}
}
