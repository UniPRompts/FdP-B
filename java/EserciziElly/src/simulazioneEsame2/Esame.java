package simulazioneEsame2;
import java.util.HashSet;

public class Esame {
    private HashSet<Studente> iscritti;
    private HashSet<Verbalizzazione> verbalizzati;

    public Esame(){
        this.iscritti = new HashSet<>();
        this.verbalizzati = new HashSet<>();
    }

    public void iscrivi(Studente obj) throws StudenteGiaIscrittoException {
        if(iscritti.contains(obj))
            throw new StudenteGiaIscrittoException();
        iscritti.add(obj);
    }

    public void verbalizza(Studente obj, int voto) throws StudenteNonIscrittoException, StudenteGiaVerbalizzatoException {

        if(!iscritti.contains(obj))
            throw new StudenteNonIscrittoException();

        for(Verbalizzazione v : verbalizzati)
            if(v.getStudente().equals(obj))
                throw new StudenteGiaVerbalizzatoException();
        try{
            Verbalizzazione verb = new Verbalizzazione(obj, voto);
            verbalizzati.add(verb);
        } catch (VotoNonConformeException e){
            System.err.println(e);
        }
    }

    @Override
    public String toString(){
        String result = "";

        if(!iscritti.isEmpty()){
            result += "Studenti iscritti: \n";
            for(Studente s : iscritti)
                result += s.toString() + "\n";
        }

        if(!verbalizzati.isEmpty()){
            result += "\nStudenti che hanno verbalizzato: \n";
            for(Verbalizzazione v : verbalizzati)
                result += v.toString() + "\n";
        }

        return result;
    }
}
