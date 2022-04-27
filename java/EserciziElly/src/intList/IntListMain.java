package intList;

public class IntListMain {
    public static void main(String[] args) {
        IntList l = new IntList();

        l.addFirst(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addFirst(0);

        System.out.println(l);
    }
}
