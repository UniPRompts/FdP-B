package serieTV;

public class Main {
    public static void main(String[] args) {
        Episode e3 = new Episode("Ep3: I saluti", "I boss se ne vanno");
        Episode e2 = new Episode("Ep2: Il pranzo", "I boss mangiano");
        Episode e1 = new Episode("Ep1: L'arrivo", "I boss sono arrivati");

        Serial s1 = new Serial("Boss delle torte");
        s1.add(e1);
        s1.add(e2);
        s1.add(e3);

        System.out.println(s1);
        System.out.println(s1.numeroEpisodi());

        Episode e6 = new Episode("Ep3: I saluti", "I boss se ne vanno");
        Episode e5 = new Episode("Ep2: Il pranzo", "I boss mangiano");
        Episode e4 = new Episode("Ep1: L'arrivo", "I boss sono arrivati");

        System.out.println(e1.equals(e4));
    }
}
