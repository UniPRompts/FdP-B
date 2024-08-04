public class IntegerCounter implements Incrementabile{
    private int n;

    public IntegerCounter(int n){
        this.n = n;
    }
    @Override
    public void increment() {
        this.n++;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    @Override
    public String toString() {
        return Integer.toString(n);
    }
}