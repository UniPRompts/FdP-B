package razionale;

public class RazionaleMain {
    public static void main(String[] args) {
        Razionale r1 = new Razionale(2, 3);
        Razionale r2 = new Razionale(1, 3);

        /*
        try{
            int den = r1.getDen();
            //r1 = new Razionale(6, 0);
        } catch(NullPointerException npe){
            System.out.println(npe.getMessage());
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        } catch(Exception any){
            System.out.println(any.getMessage());
        }
        */

        System.out.println(r1.compareTo(r2));

        //Razionale r2 = new Razionale(4, 6);
        //System.out.println("r2: " + r2);

        //System.out.println("isSimplified(r2): " + Razionale.isSimplified(r2));
        //System.out.println("r1: " + r1);
    }
}
