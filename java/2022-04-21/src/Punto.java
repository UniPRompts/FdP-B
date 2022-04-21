public class Punto {
    private int x;
    private int y;
    /**
     * Contatore statico che tiene conto di quante
     * allocazioni sono state fatte.
     * È un campo di classe,
     * è come se fosse una variabile globale
     */
    public static int allocs = 0;

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

    public static void main(String[] args) {
        Punto p1 = new Punto(1,2);
        Punto p2 = new Punto(3,4);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(Punto.allocs);
    }
}
