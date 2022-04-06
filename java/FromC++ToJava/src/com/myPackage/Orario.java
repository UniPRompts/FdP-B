package com.myPackage;
/*
 Esercizio – classe com.myPackage.Orario
 implementare in c++ una classe di nome com.myPackage.Orario che realizza il tipo di dato
 astratto ora del giorno così definito:
 valori:
     - terne <h,m, s>, con hh, mm, s numeri interi e
       0 <= h <= 23 e 0 <= m,s <= 59, che rappresentano,
       rispettivamente, le ore, i minuti e i secondi;

 operazioni su orari:
     - confronto tra due orari: operatore ==(vero se i due orari sono uguali);
     - operatore < (vero se il primo orario precede il secondo);
     - lettura e scrittura (con overloading degli operatori e <<>>) di un orario
       da/su stream nel formato h:m:s;
     - “getter” per gli attributi h, m, s;
        funzioni get_ora(), get_minuti(), get_secondi();
     - funzione di conversione da orario <h,m,s> a equivalente numero di:
       funzione to_second (); ad esempio, se a contiene l’orario <9:42:10 >>,
       a.to_seconds() restituisce 34930;
     - somma tra un orario e un dato numero di secondi: operatore ++; ad esempio, se a
       contiene l’orario 9:42:10 >>, a + 5221 restituisce il nuovo orario 11:9:11 >>.

 la classe fornisce anche un costruttore con tre parametri di tipo
 intero che rappresentano rispettivamente ore, minuti e secondi,
 e un costruttore con un parametro di tipo intero che rappresenta l’equivalente in secondi dell’orario.

 n.b. la funzione di lettura e i costruttori devono (obbligatoriamente) controllare che l’orario fornito sia corretto;
 in caso contrario, viene stampato un opportuno messaggio di errore e l’orario viene forzato al valore 0:0: 00.

 note di implementazione.
    - definire una funzione propria privata controlla_orario() che controlla
    la correttezza dell’orario.

 main di prova.
    la classe realizzata deve essere utilizzata dal main di prova messo a disposizione
    su ‘elly’ insieme al testo dell’esercizio (file orario _main.cpp cpp).
    l’esecuzione del main, completato con la classe orarioorario, deve dare i risultati riportati di seguito al main stesso. non è ammesso apportare modifiche al main.
    n.b. e' vietato: usare dichiarazioni friend, usare goto, usare variabili globali non motivate, definire public tutti i campi di una classe, usare ereditarietà a sproposito.
 */

public class Orario {
    private int s, m, h;

    // - - - - - - - - - - - - - - - - - - - -	Constructors
    public Orario(){
        this.s = 0;
        this.m = 0;
        this.h = 0;
    }
    public Orario(int h, int m, int s) {
        if(validate(h, m, s)) {
            this.h = h;
            this.m = m;
            this.s = s;
        } else {
            System.err.println("Formata orario non valido!");
            this.s = 0;
            this.m = 0;
            this.h = 0;
        }
    }
    public Orario(int s){
        toDate(s);
    }

    // - - - - - - - - - - - - - - - - - - - -	Getter
    public int getS() {
        return s;
    }
    public int getM() {
        return m;
    }
    public int getH() {
        return h;
    }
    public String getTime() {
        String time = "";

        if(getH() < 10)
            time += "0";
        time += getH() + ":";

        if(getM() < 10)
            time += "0";
        time += getM() + ":";

        if(getS() < 10)
            time += "0";
        time += getS();

        return time;
    }

    // - - - - - - - - - - - - - - - - - - - -	Utility
    private boolean validate(int h, int m, int s) {
        if(h < 0 || h > 23)
            return false;
        if(m < 0 || m > 59)
            return false;
        if(s < 0 || s > 59)
            return false;
        return true;
    }
    public boolean verify(Orario other) {
        if(this.getH() == other.getH() && this.getS() == other.getS() && this.getM() == other.getM())
            return true;
        return false;
    }
    public int toSeconds(){
        return (this.getH() * 3600) + (this.getM() * 60) + this.getS();
    }
    public void toDate(int s){
        this.h = s / 3600;
        s -= (3600 * getH());
        this.m = s / 60;
        s -= (60 * getM());
        this.s = s;
    }
    public Orario sum(int s){
        Orario o1 = new Orario(this.toSeconds() + s);
        return o1;
    }


    // - - - - - - - - - - - - - - - - - - - -	Main
    public static void main(String[] args) {
        Orario o1 = new Orario(9, 42, 10);
        Orario o2 = new Orario(34930);

        System.out.println(o1.getTime());
        System.out.println(o1.toSeconds());

        Orario o3 = o1.sum(110);
        System.out.println(o3.getTime());
    }
}






















