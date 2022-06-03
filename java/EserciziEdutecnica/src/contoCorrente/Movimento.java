package contoCorrente;

public class Movimento {
    public static final String PRELIEVO = "PRELIEVO";
    public static final String VERSAMENTO = "VERSAMENTO";
    private final String tipoMovimento;
    private final Double cifra;

    public Movimento(String tipoMovimento, Double cifra) throws TipoMovimentoNonRiconosciutoException, CifraNegativaException{
        if(tipoMovimento.equals(PRELIEVO) || tipoMovimento.equals(VERSAMENTO))
            this.tipoMovimento = tipoMovimento;
        else
            throw new TipoMovimentoNonRiconosciutoException();

        if(cifra > 0)
            this.cifra = cifra;
        else
            throw new CifraNegativaException();
    }

    @Override
    public int hashCode(){
        return (int) (cifra * 31);
    }

    @Override
    public String toString(){
        return tipoMovimento + " €" + cifra;
    }
}
