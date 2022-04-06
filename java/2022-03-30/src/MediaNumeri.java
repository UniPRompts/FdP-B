import java.util.*;

public class MediaNumeri {
    public static void main(String[] args) {
        System.out.print("Quanti numeri vuoi inserire? ");

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int somma = 0;

        for(int i = 0; i < n; i++) {
            System.out.print("Inserisci " + (i + 1) + "/" + n + " valore: ");
            int x = sc.nextInt();

            somma += x;
        }

        float media = (float) somma / n;

        System.out.println("La media è: " + media);

    }
}
