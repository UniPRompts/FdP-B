package contoCorrente;

public class Main {
    public static void main(String[] args) {
        ContoCorrente c1 = new ContoCorrente("Mattia", "Merenda", "MRNSRM", 100D);
        try{
            c1.addMovimento("VERSAMENTO", 50D);
            c1.addMovimento("VERSAMENTO", 200D);
            //c1.addMovimento("PRELIEVO", 100D);
            c1.addMovimento("VERSAMENTO", 300D);
            c1.addMovimento("VERSAMENTO", 400D);
            c1.addMovimento("VERSAMENTO", 500D);
            c1.addMovimento("VERSAMENTO", 600D);
            c1.addMovimento("VERSAMENTO", 700D);
        } catch(TipoMovimentoNonRiconosciutoException e){
            System.err.println(e);
        } catch(CifraNegativaException e){
            System.err.println(e);
        } catch(SaldoNegativoException e){
            System.err.println(e);
        }

        System.out.println(c1);

    }
}
