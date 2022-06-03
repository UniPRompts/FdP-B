package contoCorrente;

public class SaldoNegativoException extends Exception{
    public SaldoNegativoException(){
        super("Impossibile prelevare! Cifra richiesta maggiore del saldo.");
    }
}
