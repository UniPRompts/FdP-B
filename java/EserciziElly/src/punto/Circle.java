package punto;

public class Circle extends Punto{
    private int raggio;

    /**
     * Costruttori
     */
    public Circle(){
        super(0,0);
        this.raggio = 1;
    }
    public Circle(int x, int y, int raggio){
        super(x, y);
        this.raggio = raggio;
    }
    public Circle(int x, int y){
        super(x, y);
        this.raggio = 1;
    }

    /**
     * Getter
     */
    public int getRaggio(){
        return this.raggio;
    }

    /**
     * Setter
     */
    public void setRaggio(int raggio) {
        this.raggio = raggio;
    }

    /**
     * Override metodo toString
     * @return
     */
    public String toString(){
        return super.toString() + " r: " + getRaggio();
    }

    /**
     * Metodo che scala la dimensione del cerchio di una certa quantità,
     * moltiplicandone il raggio per tale quantità
     */
    public void shiftDim(int value){
        setRaggio(getRaggio() * value);
    }

    /**
     * Override metodo equals
     * @param other
     * @return
     */
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(!(other instanceof Circle))
            return false;
        if(this == other)
            return true;

        Circle tmp = (Circle) other;

        return this.getRaggio() == tmp.getRaggio() && super.equals(new Punto(tmp.getX(), tmp.getY()));
    }
}


