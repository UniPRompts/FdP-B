package games;
import cards.CardsReleased;
import users.*;

public class Game {
    public static void main(String[] args) {
        Players players = new Players();
        Dealer dealer = new Dealer();

        players.createPlayers();
        dealer.giveCards();
        players.giveCards();

        System.out.println("\n" + dealer);
        System.out.println(players);
        System.out.println(CardsReleased.print());
    }
}
