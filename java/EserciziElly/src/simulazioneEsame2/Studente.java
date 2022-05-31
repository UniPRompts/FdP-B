package simulazioneEsame2;

public class Studente implements Comparable<Studente>{
    private final String nome;
    private final String cognome;
    private final Integer matricola;

    public Studente(String nome, String cognome, Integer matricola){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }

    @Override
    public String toString(){
        return this.nome + " " + this.cognome + " " + this.matricola;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Studente other = (Studente) obj;
        return this.matricola == other.matricola;
    }

    @Override
    public int hashCode() {
        return this.matricola * 31;
    }

    @Override
    public int compareTo(Studente obj) {
        return this.matricola.compareTo(obj.matricola);
    }
}
