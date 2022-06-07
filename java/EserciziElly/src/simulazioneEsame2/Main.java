package simulazioneEsame2;

public class Main {
    public static void main(String[] args) {
        Studente s1 = new Studente("Francesco", "Rossi", 100);
        Studente s2 = new Studente("Luca", "Verdi", 101);
        Studente s3 = new Studente("Giovanni", "Bianchi", 102);
        Studente s4 = new Studente("Mario", "Neri", 103);

        Esame e1 = new Esame();

        try{
            e1.iscrivi(s1);
            //e1.iscrivi(s2);
            e1.iscrivi(s3);
            e1.iscrivi(s4);
        } catch (StudenteGiaIscrittoException e){
            System.out.println(e);
        }

        try{
            e1.verbalizza(s1, 35);
            e1.verbalizza(s1, 20);
            e1.verbalizza(s2, 30);
            e1.verbalizza(s3, 15);
            e1.verbalizza(s4, 26);
            e1.verbalizza(s4, 5);
        } catch (StudenteNonIscrittoException e){
            System.err.println(e);
        } catch (StudenteGiaVerbalizzatoException e){
            System.err.println(e);
        }

        System.out.println(e1);
    }
}
