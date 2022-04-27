package cards;
import java.util.*;

public class GenerateCard {
    /**
     * Questo metodo genera / estrae una nuova carta dal mazzo
     * Verifica se la carta generate è stata gia estratta:
     * se sì, continua a generare finchè non ne genera una nuova già
     * non estratta.
     * @return carta generata
     */
    public static Card generate(){
        Random rand = new Random();
        int number = 0;
        int suit = 0;
        Card tmp = new Card();

        do{
            number = rand.nextInt(13) + 2;
            suit = rand.nextInt(4) + 1;

            tmp.setNumber(number);
            tmp.setSuit(suit);

        } while(CardsReleased.contains(tmp));

        CardsReleased.rel.add(tmp);

        return tmp;
    }
}
