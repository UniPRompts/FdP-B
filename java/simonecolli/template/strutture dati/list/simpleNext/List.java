package list.simpleNext;

public class List<T>{

    private Node<T> head;
    private Node<T> tail;
    private int lenght;
    private static int allocLists = 0;

    public List(){
        head = null;
        tail = null;
        allocLists++;
        lenght = 0;
    }
    
    public List(Node<T> n){
        head = n;
        tail = n;
        allocLists++;
        lenght = 0;
    }
    
    public List(T v){
        Node<T> tmp = new Node<T>(v);
        head = tmp;
        tail = tmp;
        allocLists++;
        lenght = 0;
    }

    public void addNodeTop(Node<T> n){
        n.connectNext(head);
        head = n;
        if(tail == null)
            tail = n;
        lenght++;
    }

    public void addNodeTop(T v){
        Node<T> tmp = new Node<T>(v);
        tmp.connectNext(head);
        head = tmp;
        if(tail == null)
            tail = tmp;
        lenght++;
    }

    public Node<T> removeNodeTopGetNode(){
        if(head == null)
        throw new RuntimeException("Empity List");

        Node<T> tmp = head;
        head = head.getNext();
        lenght--;

        if(head == null)
            tail = null;

        return tmp;
    }

    public T removeNodeTopGetValue(){
        if(head == null)
        throw new RuntimeException("Empity List");

        Node<T> tmp = head;
        head = head.getNext();
        lenght--;

        if(head == null)
            tail = null;

        return tmp.getValue();
    }

    // public void addNodeBottom(Node<T> n){
    //     tail.connectNext(n);
    //     tail = n;
    // }
    
    public void addNodeBottom(T v){
        Node<T> tmp = new Node<T>(v);
        if(tail == null){
            head = tmp;
            tail = tmp;
        }else{
            tail.connectNext(tmp);
            tail = tmp;
        }
        lenght++;
    }
    
    public int getLenght() {
        return lenght;
    }

    
    @Override
    public String toString(){
        String tmp = "";

        Node<T> tmpNode = head;

        while(tmpNode != null){
            tmp += tmpNode.getValue().toString();
            
            if(tmpNode.getNext() != null)
                tmp += " -> ";

                tmpNode = tmpNode.getNext();
        }

        return tmp;
    }

    
}
