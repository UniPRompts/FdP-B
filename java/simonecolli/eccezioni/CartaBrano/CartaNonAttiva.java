package CartaBrano;
public class CartaNonAttiva extends RuntimeException{
    public CartaNonAttiva(){
        super("Carta non ancora attiva");
    }
}
