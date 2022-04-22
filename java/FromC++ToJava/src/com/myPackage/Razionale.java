// Codice del 20/04/2022
package com.myPackage;
import java.util.Scanner;

public class Razionale {
    private int num;
    private int den;

    /**
     * Constructor
     */
    public Razionale(){
        this(1, 1);
    }
    /**
     * Costruttore con due campi, controlla se il den != 0. Se è uguale lo inizializza a 1
     * @param num numeratore
     * @param den denominatore
     */
    public Razionale(int num, int den){
        this.num = num;
        if(validate(den))
            this.den = den;
        else{
            this.den = 1;
            System.err.println("Errore - Denominatore uguale a zero!");
        }
        //simplify();
    }
    /**
     * Getter
     * @return Denominatore
     */
    public int getDen(){
        return this.den;
    }
    /**
     * Getter
     * @return Numeratore
     */
    public int getNum() {
        return this.num;
    }

    /**
     * Stampa a video il numero
     */
    public void print(){
        if(getDen() != 1)
            System.out.println(getNum() + "/" + getDen());
        else
            System.out.println(getNum());
    }
    /**
     * Overload metodo toString
     * Ritorna il numero come stringa
     */
    public String toString(){
        if(getDen() != 1)
            return getNum() + "/" + getDen();
        return "" + getNum();
    }
    /**
     * Verifica se un numero è diverso da 0
     * @param den
     * @return true se è != 0, false altrimenti
     */
    public boolean validate(int den){
        return (den != 0);
    }

    /**
     * Effettua input di un numero razionale
     */
    public void input(){
        Scanner sc = new Scanner(System.in);
        int den, num;

        System.out.print("Inserire numeratore: ");
        num = sc.nextInt();

        do {
            System.out.print("Inserire denominatore: ");
            den = sc.nextInt();
        } while(!validate(den));

        this.den = den;
        this.num = num;

        simplify();

        sc.close();
    }

    /**
     * Calcola il minimo comune multiplo tra due numeri
     * @param a
     * @param b
     * @return mcm
     */
    public static int mcm(int a, int b) {
        return (a * b) / MCD(a, b);
    }
    /**
     * Calcola il massimo comune divisore tra due numeri
     * @param a
     * @param b
     * @return MCD
     */
    public static int MCD(int a, int b) {
        if(b == 0)
            return a;
        if(a >= b)
            return MCD(a - b, b);
        else
            return MCD(b - a, a);
    }
    /**
     * Riduce ai minimi termini, se possibile, un numero razionale
     */
    public void simplify(){
        if(getDen() % getNum() == 0){
            this.den /= this.num;
            this.num = 1;
            return;
        }
        if(getNum() % getDen() == 0){
            this.num /= this.den;
            this.den = 1;
            return;
        }
        if(MCD(getDen(), getNum()) != 1){
            int MCD = MCD(getDen(), getNum());
            this.num /= MCD;
            this.den /= MCD;
            return;
        }
    }
    /**
     * Verifica se un numero Razionale è ridotto ai minimi termini.
     * @param other numero razionale
     * @return true se verifica la condizione iniziale, false altrimenti
     */
    public static boolean isSimplified(Razionale other){
        if(other.getDen() % other.getNum() == 0)
            return false;
        if(other.getNum() % other.getDen() == 0)
            return false;
        if(MCD(other.getDen(), other.getNum()) != 1)
            return false;
        return true;
    }
    /**
     * Fa la somma tra due numeri Razionale
     * @param other
     * @return risultato Razionale
     */
    public Razionale sum(Razionale other){
        Razionale result = new Razionale();

        result.num = getNum() * other.getDen() + getDen() * other.getNum();
        result.den = getDen() * other.getDen();
        result.simplify();

        return result;
    }
    /**
     * Overload metodo Equals
     * @param other numero Razionale
     * @return true se i due numeri sono uguali, false altrimenti
     */
    public boolean equals(Razionale other){
        return getNum() == other.getNum() && getDen() == other.getDen();
    }

    /**
     * Effettua una deep copy dell'oggetto che richiama il metodo
     * @return nuovo obj con stessi valori ma reference diverse
     */
    public Razionale clone(){
        return new Razionale(getNum(), getDen());
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        Razionale r1 = new Razionale(2, 3);
        System.out.println("r1: " + r1);

        Razionale r2 = new Razionale(4, 6);
        System.out.println("r2: " + r2);

        System.out.println("isSimplified(r2): " + Razionale.isSimplified(r2));
    }

}
