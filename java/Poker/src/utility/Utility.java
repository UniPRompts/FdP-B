package utility;

import users.*;
import java.util.*;

public class Utility {

    /**
     * Ritorna il minimo valore del punto realizzato (il punto del vincitore)
     * @param players
     * @return
     */
    public static int getMin(List<User> players){
        int min = players.get(0).point;

        for(int i = 1; i < players.size(); i++)
            if(players.get(i).point < min)
                min = players.get(i).point;

        return min;
    }

    /**
     * Ritorna quanti vincitori ci sono stati
     * @param players
     * @return
     */
    public static int getNumberOfMin(List<User> players){
        int min = getMin(players);
        int c = 0;

        for(int i = 0; i < players.size(); i++)
            if(players.get(i).point == min)
                c++;

        return c;
    }
}
