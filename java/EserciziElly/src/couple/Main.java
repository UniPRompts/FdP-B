package couple;

public class Main {
    public static void main(String[] args) {
        ComparableCouple<Integer> c1 = new ComparableCouple<Integer>(1, 2);
        ComparableCouple<String> c2 = new ComparableCouple<String>("hello", "world");

        System.out.println(c1);
        System.out.println(c2);

        System.out.println(c1.greatest());
        System.out.println(c2.greatest());
    }
}
