package simulazioneEsame;

import java.util.Objects;

public class Studente /*implements Comparable<Studente>*/{
    private final String nome;
    private final String cognome;
    private final int matricola;

    public Studente(String nome, String cognome, int matricola){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }

    public int getMatricola(){
        return this.matricola;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Studente other = (Studente) obj;

        return this.matricola == other.getMatricola();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, matricola);
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + matricola;
    }

    /*
    @Override
    public int compareTo(Studente o) {
        return matricola.compareTo(o.getMatricola());
    }
    */
}
