package simulazioneEsame;

public class StudenteNonIscrittoException extends Exception{
    public StudenteNonIscrittoException(){
        super("Studente non iscritto, impossibile verbalizzare");
    }
}
