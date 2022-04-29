import games.Game;

public class Play {
    public static void main(String[] args) {
        System.out.println("Realizzato da Merenda Saverio Mattia");
        System.out.println("saveriomattia.merenda@studenti.unipr.it");

        System.out.println("\n------ POKER Texas ------");
        Game.start(true); //true: generazione casuale utenti, false: inserimento manuale
    }
}
