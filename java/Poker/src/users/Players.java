package users;
import java.io.*;
import java.util.*;

public class Players {
    public static List<User> players;

    /**
     * Costruttore
     */
    public Players(){
        players = new ArrayList<User>();
    }

    /**
     * Questo metodo chiede in input il numero e i nomi dei giocatori,
     * crea oggetto User per ogni giocatore e li inserisce nella lista players
     */
    public void createPlayers(){
        int n = 0;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Numero giocatori (1 < n < 11): ");
            n = sc.nextInt();
        } while (n < 1 || n > 10);

        for(int i = 0; i < n; i++){
            System.out.print("Inserire nome " + (i + 1) + " giocatore: ");
            String name = sc.next();

            players.add(new User(name));
        }

        sc.close();
    }

    /**
     * Genera le carte per ogni giocatore
     */
    public void giveCards(){
        for(int i = 0; i < players.size(); i++)
            players.get(i).generateCards();
    }

    /**
     * Stampa a video i nomi dei giocatori
     */
    public String printNamePlayers(){
        String str = "";

        for(int i = 0; i < players.size(); i++)
            str += players.get(i).getName() + " ";

        return str;
    }

    /**
     * Stampa a video i nomi e le carte dei giocatori
     */
    public String printCardsPlayers(){
        String str = "";

        for(int i = 0; i < players.size(); i++)
            str += players.get(i).toString() + "\n";

        return str;
    }

    /**
     * Override metodo toString
     * @return
     */
    public String toString(){
        return printCardsPlayers();
    }
}
