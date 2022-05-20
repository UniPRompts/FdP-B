package libro;

/*
    Si implementi una classe Libro con almeno il nome e il prezzo come proprietà.
    Si implementino i metodi equals, hashCode e toString.
    La classe libro è comparabile e l'ordinamento si basa sul prezzo dei libri.
    Si scriva un metodo isContained che, preso come parametro una collezione di
    libri s ritorna true se il libro è contenuto in s, false altrimenti.
 */

import java.util.HashSet;
import java.util.Objects;

public class Libro implements Comparable<Libro>{
    private String nome;
    private Double prezzo;

    // Costruttore
    public Libro(String nome, Double prezzo){
        this.nome = nome;
        this.prezzo = prezzo;
    }

    // Getter
    public Double getPrezzo() {
        return this.prezzo;
    }
    public String getNome(){
        return this.nome;
    }

    /**
     * preso come parametro una collezione di
     * libri s ritorna true se il libro è contenuto in s, false altrimenti.
     * @param obj
     * @return
     */
    public boolean isContained(HashSet<Libro> obj){
        return obj.contains(this);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Libro other = (Libro) o;
        return getNome().compareTo(other.getNome()) == 0 && getPrezzo().compareTo(other.getPrezzo()) == 0;
    }
    @Override
    public int compareTo(Libro other) {
        return prezzo.compareTo(other.getPrezzo());
    }
    @Override
    public String toString(){
        return getNome() + " €" + getPrezzo();
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, prezzo);
    }
}
