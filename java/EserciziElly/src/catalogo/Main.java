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

public class Main {
    public static void main(String[] args) {
        Articolo pane = new Articolo("pane", 1D);
        Articolo uva = new Articolo("uva", 1.5);
        Articolo uova = new Articolo("uova", 2D);

        Catalogo cibo = new Catalogo("cibo");
        cibo.addArticolo(pane);
        cibo.addArticolo(uva);
        cibo.addArticolo(uova);

        System.out.println(cibo + "\n");

        Articolo cellulare = new Articolo("cellulare", 499.99);
        Articolo tv = new Articolo("televisione", 299.99);
        Articolo pasta = new Articolo("pasta", 2D);

        Catalogo elettronica = new Catalogo("elettronica");
        elettronica.addArticolo(cellulare);
        elettronica.addArticolo(tv);
        elettronica.addArticolo(pasta);

        System.out.println(elettronica);

        System.out.println(cibo.equals(elettronica));

    }
}
