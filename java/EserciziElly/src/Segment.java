/**
 * Si consideri la classe Punto vista a lezione.
 * Si implementi in Java la classe Segment, che rappresenta un segmento collocato nel piano Cartesiano.
 * Il costruttore accetta come parametri due oggetti della classe Punto (x1,y1) e (x2,y2).
 * Implementare il metodo getMidpoint che ritorna il punto medio del segmento su cui è invocato il metodo.
 * Implementare il metodo equals in modo che due segmenti siano considerati uguali se hanno gli stessi vertici.
 * Implementare il metodo clone in modo tale che ritorni una deep copy dell'oggetto su cui è invocato il metodo.
 *
 * N.B., postare i file Punto.Java e Segmento.java. Se lo si ritiene necessario, è possibile modificare la
 * classe Punto vista a lezione.
 */
public class Segment {
    private Punto p1, p2;
    /**
     * Contatore statico che tiene conto di quante
     * allocazioni sono state fatte.
     */
    private static int allocs = 0;

    /**
     * Costruttore
     */
    public Segment(Punto p1, Punto p2){
        this.p1 = p1;
        this.p2 = p2;
        allocs++;
    }

    /**
     * Getter
     * @return
     */
    public Punto getP1() {
        return p1;
    }
    public Punto getP2() {
        return p2;
    }
    public static int getAllocs(){
        return allocs;
    }

    /**
     * Override metodo toString
     * @return
     */
    public String toString(){
        return getP1().toString() + " " + getP2().toString();
    }
    /**
     * Ritorna il punto medio del segmento
     * @return
     */
    public Punto getMidpoint(){
        return new Punto((p2.getX() + p1.getX()) / 2, (p2.getY() + p1.getY()) / 2);
    }
    /**
     * Override metodo equals
     * @param other
     * @return
     */
    public boolean equals(Segment other){
        return (p1.equals(other.p1) && p2.equals(other.p2)) || (p1.equals(other.p2) && p2.equals(other.p1));
    }
    /**
     * Override metodo cloen
     * @return
     */
    public Segment clone(){
        return new Segment(p1, p2);
    }
}
