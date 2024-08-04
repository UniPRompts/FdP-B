// package java.ereditarieta.barattoli;

public class Saliera extends Barattolo{
    private final int buchi;
    public Saliera(int volume, int contenutoEffettivo, int buchi){
        super(volume, contenutoEffettivo);
        this.buchi = buchi;
    }
    public void capovolgi(){
        super.rimuoviContenuto(buchi);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(getClass() != obj.getClass())
            return false;
        
        return super.equals(obj) && this.buchi == ((Saliera) obj).buchi;
    }

    @Override
    public String toString() {
        return super.toString() + " buchi: " + buchi;
    }
    @Override
    public int hashCode() {
        return super.hashCode() + buchi * 31;
    }
    public int getBuchi() {
        return buchi;
    }
}
