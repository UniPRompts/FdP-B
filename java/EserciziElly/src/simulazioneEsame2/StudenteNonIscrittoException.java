package simulazioneEsame2;

public class StudenteNonIscrittoException extends Exception{
    public StudenteNonIscrittoException(){
        super("Impossibile verbalizzare! - Studente non iscritto all'esame.");
    }
}
