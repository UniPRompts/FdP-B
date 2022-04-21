public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(1,2);
        Punto p2 = new Punto(3,4);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(Punto.getAllocs());
    }
}
