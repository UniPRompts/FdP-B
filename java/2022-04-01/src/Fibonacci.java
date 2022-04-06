import java.util.Scanner;

public class Fibonacci {

	public static int inputInt() {
		Scanner sc = new Scanner(System.in);
		int n;

		do {
			System.out.print("Inserire valore (> 0): ");
			n = sc.nextInt();
		} while(n < 1);

		return n;
	}

	public static int fib(int n) {
		if(n == 1 || n == 0)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		int x = inputInt();
		System.out.println("Fibonacci: " + fib(x));
	}

}
