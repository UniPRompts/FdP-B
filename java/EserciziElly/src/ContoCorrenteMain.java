public class ContoCorrenteMain {
    public static void main(String[] args) {
        ContoCorrente c1 = new ContoCorrente("Mattia", "Merenda", 2000);
        ContoCorrente c2 = new ContoCorrente("Saverio", "Merenda", 1350);

        System.out.println(c1);
        System.out.println(c2);

        if(c1.sendTo(c2, 2000))
            System.out.println("Bonifico andato a buon fine!\n");
        else
            System.out.println("Fondi insufficienti!\n");


        System.out.println(c1);
        System.out.println(c2);
    }
}
