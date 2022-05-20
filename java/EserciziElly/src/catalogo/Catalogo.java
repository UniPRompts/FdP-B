package catalogo;

/*
    Si implementi un'interfaccia Articolo che rappresenta articoli commerciali,
    dotata dei metodi getNome() che restituisce il nome dell'articolo,
    getPrezzo() che restituisce il prezzo dell'articolo e String toString() che
    restituisce una descrizione (nome e prezzo) dell'articolo.
    Si scriva una classe Catalogo<E> che rappresenta un catalogo di articoli commerciali
    (limitare opportunamente il tipo generico E). La classe memorizza gli articoli in un
    insieme ed è dotata dei metodi aggiungiArticolo(E articolo) che aggiunge un articolo
    al catalogo, Set<E> getArticoliSottoPrezzo(double prezzo) che restituisce un insieme
    di articoli il cui prezzo è minore del valore passato come parametro, e toString()
    che stampa l'intero catalogo. Implementare inoltre i metodi hashCode e equals
    della classe Catalogo<E>.
*/

import java.util.HashSet;
import java.util.Objects;

public class Catalogo<T extends Articolo> {
    public HashSet<T> set;
    private String nome;

    // Costruttore
    public Catalogo(String nome){
        this.nome = nome;
        set = new HashSet<>();
    }

    // Getter
    public String getNome(){
        return this.nome;
    }
    public int numeroArticoli(){
        return set.size();
    }

    // Setter
    public void addArticolo(T other){
        set.add(other);
    }


    /**
     * Restituisce un insieme di articoli il cui prezzo è minore del valore passato come parametro
     * @param prezzo
     * @return
     */
    public HashSet<T> getArticoliSottoPrezzo(Double prezzo){
        HashSet<T> new_set = new HashSet<>();

        for(Articolo i : set)
            if(i.getPrezzo() < prezzo)
                new_set.add((T) i);

        return new_set;
    }

    @Override
    public String toString(){
        String str = "Nome catalogo: " + nome;

        for(T i : set)
            str += "\n" + i.toString();

        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalogo other = (Catalogo) o;

        return set.equals(other.set) && nome.compareTo(other.getNome()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(set, nome);
    }
}