package users;
import java.io.*;
import java.util.*;
import winners.*;

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
        players.add(new User("user0"));
        players.add(new User("user1"));
        players.add(new User("user2"));
        players.add(new User("user3"));
        players.add(new User("user4"));
        players.add(new User("user5"));
        players.add(new User("user6"));
        players.add(new User("user7"));
        players.add(new User("user8"));
        players.add(new User("user9"));

        /*int n = 0;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Inserire il numero dei giocatori (max 10, min 2): ");
            n = sc.nextInt();
        } while (n < 2 || n > 10);

        for(int i = 0; i < n; i++){
            System.out.print("Inserire nome " + (i + 1) + " giocatore: ");
            String name = sc.next();

            players.add(new User(name));
        }

        sc.close();*/
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

    /**
     * Richiama la funzione per calcolare il punto per ogni utente
     */
    public void updatePoints(){
        for(int i = 0; i < players.size(); i++)
            Winner.returnPoints(players.get(i));
    }

    /**
     * Stampa a video il punto
     */
    public void printPoints(){
        System.out.println("Risultati:");

        for(int i = 0; i < players.size(); i++){
            switch(players.get(i).point){
                case 1:
                    System.out.println(players.get(i).getName() + " -> scala reale");
                    break;

                case 2:
                    System.out.println(players.get(i).getName() + " -> scala colore");
                    break;

                case 3:
                    System.out.println(players.get(i).getName() + " -> poker");
                    break;

                case 4:
                    System.out.println(players.get(i).getName() + " -> full");
                    break;

                case 5:
                    System.out.println(players.get(i).getName() + " -> colore");
                    break;

                case 6: System.out.println(players.get(i).getName() + " -> scala");
                    break;

                case 7:
                    System.out.println(players.get(i).getName() + " -> tris");
                    break;

                case 8:
                    System.out.println(players.get(i).getName() + " -> doppia coppia");
                    break;

                case 9:
                    System.out.println(players.get(i).getName() + " -> coppia");
                    break;

                case 10:
                    break;
            }
        }
    }
}
