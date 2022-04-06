import java.util.*;

public class Asterischi {
    public static void ast(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i + 1; j++)
                System.out.print("* ");
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserire numero asterischi: ");

        int n = sc.nextInt();

        ast(n);
    }
}
