// package java.ereditarieta.barattoli;
public class Barattolo{
    private final int volume;
    private int contenutoEffettivo;

    public Barattolo(int volume, int contenutoEffettivo){
        if(volume > contenutoEffettivo)
            throw new ContenutoEccessivo();
            this.volume = volume;
            this.contenutoEffettivo = contenutoEffettivo;
    }
    public void aggiungiContenuto(int c){
        if(contenutoEffettivo + c > volume)
            throw new RuntimeException("overflow");
        contenutoEffettivo += c;
    }
    public void rimuoviContenuto(int c){
        if(contenutoEffettivo - c < 0)
            throw new RuntimeException("underflow");
        contenutoEffettivo -= c;
    }
    @Override
    public String toString(){
        return volume + "/" + contenutoEffettivo;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        else if(obj == null || getClass() != obj.getClass())
            return false;
        Barattolo other = (Barattolo) obj;
        return this.volume == other.volume && this.contenutoEffettivo == other.contenutoEffettivo;
    }
    @Override
    public int hashCode(){
        return this.volume*31 + this.contenutoEffettivo*17;
    }
    
}