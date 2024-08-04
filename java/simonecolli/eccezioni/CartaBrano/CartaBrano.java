package CartaBrano;
public class CartaBrano{
    private int numeroBrani;
    private boolean attiva;

    public CartaBrano(int numeroBrani){
        this.numeroBrani = numeroBrani;
        this.attiva = false;
    }
    public void attiva(){
        if(attiva)
            throw new CartaGiaAttiva();
        attiva = true;
    }

    public void compraBrano(){
        if(!attiva)
            throw new CartaNonAttiva();
        if(numeroBrani == 0)
            throw new BraniEsauriti();
        numeroBrani--;
    }
    public int braniRimanenti(){
        return this.numeroBrani;
    }
    public static void main(String[] args) {
        CartaBrano c = new CartaBrano(4);

        try {//errore
            c.compraBrano();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            c.attiva();
            System.out.println(c.braniRimanenti());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {//errore
            c.attiva();
            System.out.println(c.braniRimanenti());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        try {//3
            c.compraBrano();            
            System.out.println(c.braniRimanenti());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {//2
            c.compraBrano();
            System.out.println(c.braniRimanenti());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {//1
            c.compraBrano();            
            System.out.println(c.braniRimanenti());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {//0
            c.compraBrano();            
            System.out.println(c.braniRimanenti());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {//error
            c.compraBrano();            
            System.out.println(c.braniRimanenti());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}