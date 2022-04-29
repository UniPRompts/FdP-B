package users;
import java.io.*;
import java.util.*;

import utility.*;
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
     * Stampa a video il punto per ogni giocatore (se è stato effettuato)
     */
    public void printPoints(){
        System.out.println("Risultati:");

        for(int i = 0; i < players.size(); i++){
            if(players.get(i).point != 10)
                System.out.println(players.get(i).getName() + " -> " + players.get(i).getPointToString());
        }
    }

    /**
     * In caso di piu utenti con lo stesso punto,
     * ritorna quello con le carte maggiori
     * @return
     */
    public User getRealWinner(){
        User winner = null;
        boolean first = false;
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).point == Utility.getMin(players)){
                if(!first){
                    winner = players.get(i);
                    first = true;
                }
                else {
                    int sum1 = winner.getC1().getNumber() + winner.getC2().getNumber();
                    int sum2 = players.get(i).getC1().getNumber() + players.get(i).getC2().getNumber();

                    if(sum2 > sum1)
                        winner = players.get(i);
                }
            }
        }
        return winner;
    }

    /**
     * Stampa a video il vincitore
     */
    public void printWinner(){
        int min = Utility.getMin(players);

        System.out.println("\nVincitore: ");
        if(Utility.getNumberOfMin(players) == 1){
            for(int i = 0; i < players.size(); i++)
                if(players.get(i).point == min)
                    System.out.println(players.get(i).toString() + "\n\t-> " + players.get(i).getPointToString());
        } else
            System.out.println(getRealWinner().toString() + "\n\t-> " + getRealWinner().getPointToString());
    }
}
