package catalogo;

/*
    Si implementi una classe Mobile che implementa l'interfaccia Articolo
    definita nell'esercizio "Catalogo" del forum. La classe Mobile rappresenta
    articoli per arredamento. La classe Mobile definisce i metodi int getLarghezza(),
    int getAltezza() e int getProfondita() che restituiscono le dimensioni di un mobile.
    Si implementi un metodo scegliMobiliDaCatalogo che riceve in ingresso un catalogo
    di oggetti di tipo Mobile e restituisce un insieme di mobili il cui prezzo è
    inferiore al prezzo del mobile su cui il metodo è chiamato e le cui dimensioni sono
    inferiori alle dimensioni del mobile su cui il metodo è chiamato
 */

import java.util.HashSet;

public class Mobile extends Articolo implements ArticoloVendibile {
    private int larghezza;
    private int altezza;
    private int profondita;

    // Costruttore
    public Mobile(String nome, Double prezzo, int larghezza,
                  int altezza, int profondita){
        super(nome, prezzo);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondita = profondita;
    }

    // Getter
    public int getAltezza() {
        return altezza;
    }
    public int getLarghezza() {
        return larghezza;
    }
    public int getProfondita() {
        return profondita;
    }

    /**
     * @param obj catalogo di oggetti di tipo Mobile
     * @return insieme di mobili il cui prezzo è inferiore al prezzo del mobile su cui il
     *      metodo è chiamato e le cui dimensioni sono inferiori alle dimensioni
     *      del mobile su cui il metodo è chiamato
     */
    public HashSet<Mobile> scegliMobiliDaCatalogo(Catalogo<Mobile> obj){
        HashSet<Mobile> new_set = new HashSet<Mobile>();

        for(Mobile i : obj.set)
            if(getPrezzo() < i.getPrezzo())
                if(getLarghezza() < i.getLarghezza())
                    if(getAltezza() < i.getAltezza())
                        if(getProfondita() < i.getProfondita())
                            new_set.add(i);

        return new_set;
    }

    @Override
    public String toString(){
        return super.toString() +
                " -> dim: " +
                "" + getAltezza() +
                "x" + getLarghezza() +
                "x" + getProfondita() + " cm";
    }
}
