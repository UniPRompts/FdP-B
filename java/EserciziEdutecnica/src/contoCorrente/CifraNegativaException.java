package contoCorrente;

public class CifraNegativaException extends Exception{
    public CifraNegativaException(){
        super("Cifra negativa!! Deve essere maggiore di 0.");
    }
}
