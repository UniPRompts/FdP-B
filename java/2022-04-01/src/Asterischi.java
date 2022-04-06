import java.util.*;
public class Asterischi {
	
	public static void build(int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++)
				System.out.print("* ");
			System.out.println();
		}
		
		for(int i = n - 1; i > 0; i--) {
			for(int j = 0; j < i; j++)
				System.out.print("* ");
			System.out.println();
		}
			
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("Inserire numero (> 0): ");
			n = sc.nextInt();
		} while(n < 1);
		
		build(n);
		
		sc.close();

	}

}
