package ContatorePersone;

public class ContatoreNegativoException extends RuntimeException{
    public ContatoreNegativoException(){
        super("Numero negativo");
    }
}
