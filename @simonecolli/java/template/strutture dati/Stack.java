import list.simpleNext.*;

public class Stack<T>{

    private List<T> s;

    public Stack(){
        s = new List<T>();
    }

    public void push(T e){
        s.addNodeTop(e);
    }

    public boolean isEmpity(){
        
        if(s.getLenght() == 0)
            return true;
        return false;
    
    }
    public T pop(){
        if(isEmpity())
            throw new RuntimeException("Empity Stack");
        return s.removeNodeTopGetValue();
    }

    @Override
    public String toString() {
        return s.toString();
    }
    
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Stack: " + s);
        System.out.println(s.pop());
        
        System.out.println("Stack: " + s);
        System.out.println(s.pop());

        System.out.println("Stack: " + s);
        System.out.println(s.pop());

        System.out.println("Stack: " + s);

    }
}