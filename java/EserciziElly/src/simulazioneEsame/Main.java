package simulazioneEsame;

public class Main {
    public static void main(String[] args) {
        Studente s1 = new Studente("mattia", "merenda", 1);
        Studente s2 = new Studente("giulia", "tomasello", 2);
        Studente s3 = new Studente("antonio", "godino", 3);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);


        Esame e1 = new Esame("Informatica");

        try {
            e1.iscrivi(s1);
            e1.iscrivi(s2);
            e1.iscrivi(s1);
        } catch (StudenteGiaIscrittoException e) {
            System.out.println(e);
        }

        System.out.println("\n" + e1);

        try{
            e1.verbalizza(s1, 27);
            e1.verbalizza(s3, 30);
        } catch (StudenteGiaVerbalizzatoException e){
            System.out.println(e);
        } catch (StudenteNonIscrittoException e){
            System.out.println(e);
        }

        System.out.println("\n" + e1);
    }
}
