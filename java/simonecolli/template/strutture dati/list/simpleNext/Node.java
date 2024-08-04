package list.simpleNext;

public class Node<T>{
    private Node<T> next;
    private final T value;

    private static int allocNodes = 0;

    public Node(T value){
        this.value = value;
        next = null;
        allocNodes++;
    }
    public Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
        allocNodes++;
    }
    
    public void connectNext(Node<T> next){
        this.next = next;
    }

    public static int getAllocNodes() {
        return allocNodes;
    }
    public T getValue() {
        return value;
    }
    public Node<T> getNext() {
        return next;
    }
    

}
