package rettangolo;

public class Rettangolo {
    protected int h;
    protected int l;

    /**
     * Costruttore
     */
    public Rettangolo(){
        this.h = this.l = 1;
    }
    public Rettangolo(int h, int l){
        this.l = l;
        this.h = h;
    }

    /**
     * Getter
     * @return
     */
    public int getH() {
        return h;
    }
    public int getL() {
        return l;
    }
    public int getPerimetro(){
        return h * 2 + l * 2;
    }

    public String toString(){
        return "H: " + getH() + "\nL: " + getL() + "\n2P: " + getPerimetro();
    }
}
