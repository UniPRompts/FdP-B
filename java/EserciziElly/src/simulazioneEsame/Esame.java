package simulazioneEsame;

import java.util.HashSet;

public class Esame {
    private final String nomeEsame;
    private HashSet<Studente> iscrizioni;
    private HashSet<Verbalizzazione> verbalizzazioni;

    public Esame(String nomeEsame){
        this.nomeEsame = nomeEsame;
        this.iscrizioni = new HashSet<Studente>();
        this.verbalizzazioni = new HashSet<Verbalizzazione>();
    }

    public void iscrivi(Studente other) throws StudenteGiaIscrittoException {
        if(!iscrizioni.contains(other))
            iscrizioni.add(other);
        else
            throw new StudenteGiaIscrittoException();
    }

    public void verbalizza(Studente other, int voto) throws StudenteNonIscrittoException, StudenteGiaVerbalizzatoException {
        if(!iscrizioni.contains(other))
            throw new StudenteNonIscrittoException();

        Verbalizzazione verb = new Verbalizzazione(other, voto);

        for(Verbalizzazione v : verbalizzazioni)
            if(v.getStudente().equals(other))
                throw new StudenteGiaVerbalizzatoException();

        verbalizzazioni.add(verb);
    }

    public String toString(){
        String result = "";

        if(iscrizioni.size() != 0){
            result += "Studenti iscritti: \n";
            for(Studente is : iscrizioni)
                result += (is.toString() + "\n");
        }

        if(verbalizzazioni.size() != 0){
            result += "Studenti verbalizzati: \n";
            for(Verbalizzazione ver : verbalizzazioni)
                result += (ver.toString() + "\n");
        }

        return result;
    }
    // da finire
}
