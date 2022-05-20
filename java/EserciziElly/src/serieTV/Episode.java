package serieTV;

public class Episode {
    private String titolo;
    private String trama;

    // Costruttori
    public Episode(){
        this(null, null);
    }
    public Episode(String titolo, String trama){
        this.titolo = titolo;
        this.trama = trama;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Episode other = (Episode) obj;
        return this.titolo.compareTo(other.titolo) == 0;
    }

    @Override
    public String toString(){
        String str = "";

        str += "\nTitolo: " + this.titolo;
        str += "\nTrama: " + this.trama;

        return  str;
    }

}
