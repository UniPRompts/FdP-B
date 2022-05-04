package rettangolo;

public class Quadrato extends Rettangolo{
    public Quadrato(int l){
        super(l, l);
    }

    public static void main(String[] args) {
        Quadrato q = new Quadrato(5);
        Rettangolo r = new Rettangolo(4, 7);

        System.out.println(q);
        System.out.println(r);
    }
}
