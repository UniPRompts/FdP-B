import list.simpleNext.List;
import list.simpleNext.Node;

public class Main{
    public static void main(String[] args) {
        List<Integer> l = new List<Integer>();

        Node<Integer> n = new Node<Integer>(4);

        l.addNodeTop(10);
        System.out.println("add");
        l.addNodeTop(20);
        System.out.println("add");
        l.addNodeBottom(30);
        System.out.println("add");
        l.addNodeTop(40);
        System.out.println("add");
        l.addNodeTop(n);
        System.out.println("add");
        // l.addNodeBottom(n);
        System.out.println("add");
        l.addNodeTop(40);
        System.out.println("add");

        
        System.out.println(l);
    }
}
