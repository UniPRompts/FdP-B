package catalogo;

import java.util.Objects;

public class Articolo implements ArticoloVendibile{
    private String nome;
    private double prezzo;

    public Articolo(String nome, double prezzo){
        this.nome = nome;
        this.prezzo = prezzo;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public Double getPrezzo() {
        return this.prezzo;
    }

    @Override
    public String toString(){
        return getNome() + " €" + getPrezzo();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Articolo other = (Articolo) obj;

        return nome.compareTo(other.getNome()) == 0 && getPrezzo().compareTo(other.getPrezzo()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, prezzo);
    }
}
