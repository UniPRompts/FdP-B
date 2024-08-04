public class Cards implements Comparable<Cards>{

    private static int counter = 0;
    private final String contenuto;
    private final int n;
    public Cards(){
        contenuto = "";
        n = 0;
    }
    public Cards(String contenuto){
        this.contenuto = contenuto;
        this.n = counter;
        counter++;
    }
    @Override
    public int compareTo(Cards o){
        if(this.equals(o))
            return 0;
        if(this.n < ((Cards)o).n)
            return -1;
        return 1;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contenuto == null) ? 0 : contenuto.hashCode());
        result = prime * result + n;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cards other = (Cards) obj;
        if (contenuto == null) {
            if (other.contenuto != null)
                return false;
        } else if (!contenuto.equals(other.contenuto))
            return false;
        if (n != other.n)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "\n" + n + " - " + contenuto + "\n";
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return new Cards(this.contenuto);
    }
    public static int getCounter() {
        return counter;
    }
    public static void setCounter(int counter) {
        Cards.counter = counter;
    }
    public String getContenuto() {
        return contenuto;
    }
    public int getN() {
        return n;
    }
}
