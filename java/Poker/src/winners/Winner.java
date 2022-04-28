package winners;
import cards.*;
import users.*;

public class Winner {
    public static int getOccorrenze(Card card){
        int c = 0;

        for(int i = 0; i < Dealer.cards.size(); i++)
            if(card.getNumber() == Dealer.cards.get(i).getNumber())
                c++;

        return c;
    }

    /**
     * Coppia in mano
     * @param user
     * @return
     */
    public static boolean coppiaInMano(User user){
        return user.getC1().getNumber() == user.getC2().getNumber();
    }

    /**
     * Coppia
     * @param user
     * @return
     */
    public static boolean coppia(User user){
        int c1 = getOccorrenze(user.getC1());
        int c2 = getOccorrenze(user.getC2());

        if(coppiaInMano(user)) return true;
        return c1 == 1 || c2 == 1;
    }

    /**
     * Doppia coppia
     * @param user
     * @return
     */
    public static boolean doppiaCoppia(User user){
        int c1 = getOccorrenze(user.getC1());
        int c2 = getOccorrenze(user.getC2());

        return c1 == 1 && c2 == 1;
    }

    /**
     * Tris
     * @param user
     * @return
     */
    public static boolean tris(User user){
        int c1 = getOccorrenze(user.getC1());
        int c2 = getOccorrenze(user.getC2());

        if(coppiaInMano(user) && c1 == 1) return true;
        return c1 == 2 || c2 == 2;
    }

    /**
     * Poker
     * @param user
     * @return
     */
    public static boolean poker(User user){
        int c1 = getOccorrenze(user.getC1());
        int c2 = getOccorrenze(user.getC2());

        if(coppiaInMano(user) && (c1 == 2 || c2 == 2)) return true;
        return c1 == 3 || c2 == 3;
    }

    public static int returnPoints(User user){
        int point = 0;

        if(poker(user)){
            //point = 3
            System.out.println(user.getName() + " poker");
        } else if(tris(user)){
            //point = 7;
            System.out.println(user.getName() + " tris");
        } else if(doppiaCoppia(user)){
            //point = 8;
            System.out.println(user.getName() + " doppia coppia");
        } else if(coppia(user)) {
            //point = 9;
            System.out.println(user.getName() + " coppia");
        }


        return point;
    }
}
