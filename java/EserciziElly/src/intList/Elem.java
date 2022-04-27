package intList;

public class Elem {
    private int value;
    private Elem next;

    /**
     * Costruttore
     * @param value
     */
    public Elem(int value){
        this(value, null);
    }
    public Elem(int value, Elem next){
        setValue(value);
        setNext(next);
    }

    /**
     * Getter
     * @return
     */
    int getValue(){
        return this.value;
    }
    Elem getNext(){
        return next;
    }

    /**
     * Setter
     * @param value
     */
    void setValue(int value){
        this.value = value;
    }
    void setNext(Elem next){
        this.next = next;
    }
}
