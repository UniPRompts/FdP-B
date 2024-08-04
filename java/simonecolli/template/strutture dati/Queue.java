import list.simpleNext.List;

public class Queue<T>{
    private List<T> q;
    private static int allocsQueue = 0;
    public Queue(){
        q = new List<T>();
        allocsQueue++;
    }

    public void enqueue(T v){
        q.addNodeBottom(v);
    }

    public T dequeue(){
        if(isEmpity())
            throw new RuntimeException("Empity Queue");
        return q.removeNodeTopGetValue();
    }

    public boolean isEmpity(){
        
        if(q.getLenght() == 0)
            return true;
        return false;
    
    }

    @Override
    public String toString() {
        return q.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Queue: " + q);
        System.out.println(q.dequeue());

        System.out.println("Queue: " + q);
        System.out.println(q.dequeue());

        System.out.println("Queue: " + q);
        System.out.println(q.dequeue());
        
        System.out.println("Queue: " + q);

    }
}
