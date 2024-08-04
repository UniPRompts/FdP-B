package ContatorePersone;

public class ContatoreStanza {
    private int numeroPersone;
    public ContatoreStanza(){
        this(0);
    }
    public ContatoreStanza(int n){
        if(n < 0){
            numeroPersone = 0;
            throw new ContatoreNegativoException();
        }
        numeroPersone = n;
    }
    public void aggiungiPersona(){
        numeroPersone++;
    }
    public void rimuoviPersona(){
        if(numeroPersone == 0)
            throw new ContatoreNegativoException();
        numeroPersone--;
    }
    public int getContatore(){
        return numeroPersone;
    }
    
}
