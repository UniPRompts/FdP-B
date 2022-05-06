package punto;

public class MainCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(0,0);
        Circle c3 = new Circle(5,2,8);

        System.out.println(c1.equals(c2));
    }
}
