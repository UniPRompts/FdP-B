public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(2, 5);
        Punto p2 = new Punto(6, 7);
        Punto p3 = new Punto(1, 6);
        Punto p4 = new Punto(3, 9);

        Segment s1 = new Segment(p1, p2);
        Segment s2 = new Segment(p3, p4);

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
    }
}
