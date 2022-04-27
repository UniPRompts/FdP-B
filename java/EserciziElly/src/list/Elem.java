package list;

public class Elem<T> {
    private T value;
    private Elem next;

    /**
     * Costruttore
     * @param value
     */
    public Elem(T value){
        this(value, null);
    }
    public Elem(T value, Elem<T> next){
        setValue(value);
        setNext(next);
    }

    /**
     * Getter
     * @return
     */
    T getValue(){
        return this.value;
    }
    Elem<T> getNext(){
        return next;
    }

    /**
     * Setter
     * @param value
     */
    void setValue(T value){
        this.value = value;
    }
    void setNext(Elem<T> next){
        this.next = next;
    }
}
