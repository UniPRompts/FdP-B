public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(1,2);
        Punto p2 = new Punto(3,4);

        Integer[] a = {2, 5 ,1 , 8};
        System.out.println(ArrayUtility.search(a, 5));
        ArrayUtility.sort(a);
        System.out.println(ArrayUtility.toString(a));
    }
}
