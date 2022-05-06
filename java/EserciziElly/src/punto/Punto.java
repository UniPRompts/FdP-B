package punto;

public class Punto {
    protected int x;
    protected int y;
    /**
     * Contatore statico che tiene conto di quante
     * allocazioni sono state fatte.
     * È un campo di classe,
     * è come se fosse una variabile globale
     */
    private static int allocs = 0;

    /**
     * Costruttori
     */
    public Punto(){
        this(0,0);
    }
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
        allocs++;
    }

    /**
     * Getter
     * @return
     */
    public int getY() {
        return this.y;
    }
    public int getX() {
        return this.x;
    }
    public static int getAllocs(){
        return allocs;
    }

    /**
     * Setter
     */
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Override metodo toString
     * @return
     */
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }
    /**
     * Override metodo clone
     * @return
     */
    public Punto clone(){
        return new Punto(getX(), getY());
    }
    /**
     * Override metodo equals
     * @param other
     * @return
     */
    public boolean equals(Punto other) {
        return getX() == other.getX() && getY() == other.getY();
    }

    /**
     * Metodo che sposta il punto orizzontalmente di una certa distanza
     * @param value
     */
    public void shiftX(int value){
        setX(getX() + value);
    }
    /**
     * Metodo che sposta il punto verticalmente di una certa distanza
     * @param value
     */
    public void shiftY(int value){
        setY(getY() + value);
    }
}
