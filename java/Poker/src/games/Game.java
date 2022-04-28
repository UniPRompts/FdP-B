package games;
import cards.*;
import users.*;

public class Game {
    public static void start(){
        Players players = new Players();
        Dealer dealer = new Dealer();

        players.createPlayers();
        dealer.giveCards();
        players.giveCards();

        System.out.println("\n" + dealer);
        System.out.println(players);

        players.updatePoints();
        players.printPoints();

        System.out.println("\n" + CardsReleased.print());
    }
}
