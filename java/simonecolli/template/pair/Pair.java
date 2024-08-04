public class Pair<T extends Incrementabile, K>{

    private static int numberOfPair = 0;
    private T contatore;
    private K eleK;

    public Pair(T contatore, K eleK){
        this.contatore = contatore;
        this.eleK = eleK;
        numberOfPair++;
    }

    @Override
    public String toString() {
        return "[" + contatore.toString() + " - " + eleK.toString() + "]";
    }

    public void increment(){
        contatore.increment();
    }

}