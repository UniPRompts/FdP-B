package contoCorrente;

public class TipoMovimentoNonRiconosciutoException extends Exception{
    public TipoMovimentoNonRiconosciutoException(){
        super("Tipo movimento non riconosciuto! Riprovare.");
    }
}
