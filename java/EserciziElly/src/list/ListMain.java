package list;

public class ListMain {
    public static void main(String[] args) {
        List<Integer> l = new List();

        l.addFirst(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addFirst(0);

        System.out.println(l);
    }
}
