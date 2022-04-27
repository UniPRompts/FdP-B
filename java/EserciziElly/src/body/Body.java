package body;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Si implementi in Java una classe body.Body che rappresenta un corpo puntiforme dotato di massa,
 * che cade soggetto solo alla forza di gravità terrestre.
 * Il costruttore prende come parametro la massa del corpo e la sua altezza iniziale.
 * Si supponga che tutte le grandezze siano espresse in unità tra loro omogenee
 * (altezza in metri, velocità in metri al secondo, etc.).
 * Si implementi il metodo progress che simula il passaggio di un certo numero di secondi.
 * Si implementi un metodo getString che ritorna una stringa che contiene le informazioni
 * riguardanti l'altezza dal suolo e la velocità corrente del corpo.
 * Si ricordato le equazioni del moto uniformemente accelerato (immagine in allegato)
 * v = v0 + at
 * s = s0 + v0t + (1/2)at^2
 */

public class Body {
    private Float massa, altezza;

    /**
     * Constructor
     * @param massa
     * @param altezza
     */
    public Body(Float massa, Float altezza){
        this.altezza = altezza;
        this.massa = massa;
    }

    //  GETTER
    public Float getMassa(){
        return this.massa;
    }
    public Float getAltezza(){
        return this.altezza;
    }

    /**
     * Calcola la velocità attuale dati i seguenti dati
     * @param velIniziale velocità iniziale
     * @param accellerazione accellerazione corpo
     * @param time tempo trascorso
     * @return velocità in m/s
     */
    public Float getVelocita(Float velIniziale, Float accellerazione, Float time){
        return (velIniziale + accellerazione * time);
    }

    /**
     * Calcola lo spazio percorso dati i seguenti dati
     * @param spazioIniziale spazio percorso iniziale
     * @param velIniziale valocità iniziale
     * @param accellerazione accellerazione corpo
     * @param time tempo trascorso
     * @return metri percorsi
     */
    public Float getSpazio(Float spazioIniziale, Float velIniziale, Float accellerazione, Float time){
        return (spazioIniziale + velIniziale * time + (accellerazione * time * time) / 2);
    }

    /**
     * Stampa a video tutti i dati
     */
    public void getString(){
        Float time = process();
        Float spazio = getSpazio((float) 0, (float) 0, (float) 9.8, time);

        System.out.println("Altezza iniziale: " + getAltezza() + " m");
        System.out.println("Intervallo di tempo: " + time + " s");
        System.out.println("Velocita corrente: " + getVelocita((float) 0, (float) 9.8, time) + " m/s");
        System.out.println("Spazio percorso: " + spazio + " m");

        if(spazio >= getAltezza()) System.out.println("Il corpo si è schiantato a terra :(");
        else System.out.println("Altezza attuale: " + (getAltezza() - spazio) + " m");
    }

    /**
     * Genera un numero random compreso tra 0 e 10
     * @return tempo trascorso per calcolare getSpazio e getVelocita
     */
    public static Float process(){
        return ThreadLocalRandom.current().nextFloat() * 10;
    }
}
