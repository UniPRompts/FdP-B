public class Main{
    public static void main(String[] args) {
        Pair<IntegerCounter, String> p = new Pair<IntegerCounter, String>(new IntegerCounter(0), "stringa 1");
        System.out.println(p);
        p.increment();

        System.out.println(p);
    }
}
