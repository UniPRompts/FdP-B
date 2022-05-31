package simulazioneEsame2;

public class VotoNonConformeException extends Exception{
    public VotoNonConformeException(){
        super("Impossibile inserire voto, minore di 0 o maggiore di 30.");
    }
}
