package dadi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DadoTruccato d1 = new DadoTruccato();
        DadoConMemoria d2 = new DadoConMemoria();

        Scanner sc = new Scanner(System.in);
        System.out.print("Numero lanci: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Dado truccato: " + d1.lancio());
            System.out.println("Dado con memoria: " + d2.lancio());
            System.out.println();
        }


    }
}
