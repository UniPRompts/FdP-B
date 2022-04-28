package cassaforte;

public class CassaforteMain {
    public static void main(String[] args) {
        Cassaforte c = new Cassaforte("Ugo degli Ughi", 1234);

        try{
            System.out.println(c.open(2222));
            System.out.println(c.open(1111));
            System.out.println(c.open(1232));
            System.out.println(c.open(1234)); //combinazione giusta al 4 tentativo
        } catch (Exception e){
            System.err.println("Tentativi massimi raggiunti!!\nNon puoi più accedere al contenuto :(");
        }

    }
}
