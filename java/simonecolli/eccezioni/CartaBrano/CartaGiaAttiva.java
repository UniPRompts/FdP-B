package CartaBrano;
public class CartaGiaAttiva extends RuntimeException {
    public CartaGiaAttiva(){
        super("Carta già attiva");
    }
}
