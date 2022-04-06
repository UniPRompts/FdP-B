import java.util.*;
public class Inverti {


	public static int inputInt() {
		Scanner sc = new Scanner(System.in);
		int n;

		do {
			System.out.print("Inserire dimensione array (> 0): ");
			n = sc.nextInt();
		} while(n < 1);

		return n;
	}
	public static void inputArray(int[] a, int dim) {
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < dim; i++){
			System.out.print("Inserire " + (i + 1) + "/" + dim + " elemento: ");
			a[i] = sc.nextInt();
		}
		sc.close();
	}
	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static void inverti(int[] a, int init, int end) {
		if(init >= end)
			return;
		else {
			int tmp = a[init];
			a[init] = a[end];
			a[end] = tmp;

			inverti(a, init + 1, end - 1);
		}
	}
	
	public static void main(String[] args) {
		int dim = inputInt();

		int[] a = new int[dim];

		inputArray(a, dim);

		printArray(a);

		inverti(a, 0, dim - 1);

		printArray(a);
	}

}
