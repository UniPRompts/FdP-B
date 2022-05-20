package couple;

public class Couple<T extends Comparable<T>> {
    private final T first;
    private final T second;

    public Couple(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public T greatest(){
        if(first.compareTo(second) > 0)
            return first;
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
