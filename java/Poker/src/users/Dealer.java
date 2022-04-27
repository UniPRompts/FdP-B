package users;
import cards.Card;
import cards.GenerateCard;

import java.util.*;

public class Dealer {
    private String name = "Dealer";
    public static List<Card> cards = new ArrayList<Card>();
    public static List<Card> cardsDiscarded = new ArrayList<Card>();

    /**
     * Genera le carte del dealer / banco.
     * Genera le prime tre carte (FLOP)
     * Ne scarta una
     * Genera la quarta carta (TURN)
     * Ne scarta una
     * Genera l'ultima carta (RIVER)
     */
    public void giveCards(){
        cards.add(GenerateCard.generate());
        cards.add(GenerateCard.generate());
        cards.add(GenerateCard.generate());

        cardsDiscarded.add(GenerateCard.generate());

        cards.add(GenerateCard.generate());

        cardsDiscarded.add(GenerateCard.generate());

        cards.add(GenerateCard.generate());
    }

    public String toString(){
        String str = "Dealer: ";
        for (int i = 0; i < cards.size(); i++)
            str += cards.get(i) + " ";
        return str;
    }

}
