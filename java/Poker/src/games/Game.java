package games;
import cards.*;
import users.*;

public class Game {
    public static void start(boolean mode){
        Players players = new Players();
        Dealer dealer = new Dealer();

        players.createPlayers(mode);
        dealer.giveCards();
        players.giveCards();

        System.out.println("\n" + dealer);
        System.out.println(players);

        players.updatePoints();
        players.printPoints();
        players.printWinner();

        //System.out.println("\n" + CardsReleased.print());
    }
}
