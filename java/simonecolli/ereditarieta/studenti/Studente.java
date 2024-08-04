import java.util.HashSet;

public class Studente extends Persona {
    private HashSet<Voto> voti;
    public Studente(String nome, String cognome, String compleanno){
        super(nome, cognome, compleanno);
        voti = new HashSet<Voto>();
    }
    
    public void addVoto(Voto v){
        if(voti.contains(v))
            throw new RuntimeException("voto già presente");
        voti.add(v);
    }
    
    @Override
    public String toString() {
        String tmp = "";
        tmp += super.toString() + "\nStato:\n";
        for(Voto v : voti)
            tmp += v.toString() + "\n";
        
        return tmp;
    }

    public int totCFU(){
        int tmp = 0;
        for(Voto v : voti)
            tmp += v.getCFU();
        return tmp; 
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
