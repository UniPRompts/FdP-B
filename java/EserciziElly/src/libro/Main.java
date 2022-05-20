package libro;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Libro l1 = new Libro("Geronimo", 10D);
        Libro l2 = new Libro("Javier", 15D);
        Libro l3 = new Libro("Maldini", 20D);
        Libro l4 = new Libro("Pippo", 20D);

        HashSet<Libro> set = new HashSet<Libro>();

        set.add(l1);
        set.add(l2);
        set.add(l3);

        System.out.println(set);

        System.out.println(l4.isContained(set));
    }
}
