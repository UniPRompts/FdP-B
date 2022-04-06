import java.util.*;

public class CifrarioCesare {

	public static char converti(char x) {
		if(x < 97 || x > 122)
			return '?';
		if(x < 120)
			return (char) (x + 3);
		else
			return (char) (((x + 3) % 122) + 97);
	}

	public static void main(String[] args) {
		char a, b, c;

		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire tre caratteri: ");

		a = sc.next().charAt(0);
		b = sc.next().charAt(0);
		c = sc.next().charAt(0);

		System.out.println(converti(a));
		System.out.println(converti(b));
		System.out.println(converti(c));

	}

}
