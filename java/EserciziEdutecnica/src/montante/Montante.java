package montante;/*
Es. 5
    Basandosi sulla formula del montante: M=C·(1+i)^n dove:
        C=capitale iniziale
        i=tasso di interesse (float)
        n=numero di anni
        M=montante.Montante restituito dalla banca dopo n anni al tasso i.
    Scrivi un programma che dato un il tasso di interesse (ad es.3%) dica
    dopo quanti anni raddoppierà il capitale iniziale.
 */

import java.util.Scanner;

public class Montante {
    /**
     * La funzione calcola quanti anni ci vogliono per raddoppiare un capitale con un determinato interesse
     * @param money capitale iniziale
     * @param interest interesse annuale
     * @return il numero di anni necessari per raddoppiare il capitale
     */
    public static int calcola(Float money, Float interest){
        Integer year = 0;
        Float calc = money;

        while(calc <= 2 * money){
            calc += (calc * interest / 100);
            year++;
            System.out.println("Anno: " + year + " -> " + calc);
        }

        return year;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserire quantità capirale: ");
        Float money = sc.nextFloat();
        System.out.print("Inserire l'interesse annuo: ");
        Float interest = sc.nextFloat();

        System.out.println("Capitale raddoppiato in " + calcola(money, interest) + " anni");
    }
}
