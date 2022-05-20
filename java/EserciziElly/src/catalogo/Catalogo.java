package catalogo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Catalogo {
    public HashSet<Articolo> set;
    private String nome;

    public String getNome(){
        return this.nome;
    }

    public Catalogo(String nome){
        this.nome = nome;
        set = new HashSet<>();
    }

    public void addArticolo(Articolo other){
        set.add(other);
    }

    public int numeroArticoli(){
        return set.size();
    }

    public HashSet<Articolo> getArticoliSottoPrezzo(Double prezzo){
        HashSet<Articolo> new_set = new HashSet<>();

        for(Articolo i : set)
            if(i.getPrezzo() < prezzo)
                new_set.add(i);

        return new_set;
    }

    @Override
    public String toString(){
        String str = "Nome catalogo: " + nome;

        for(Articolo i : set)
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
