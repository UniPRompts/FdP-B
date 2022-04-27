package cards;
import java.util.*;

public class CardsReleased {
    /**
     * Java doc: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
     */
    public static List<Card> rel = new ArrayList<Card>();

    public static boolean contains(Card other){
        for (int i = 0; i < rel.size(); i++)
            if(rel.get(i).getSuit() == other.getSuit() && rel.get(i).getNumber() == other.getNumber())
                return true;
        return false;
    }

    public static String print(){
        String str = "";
        str += "Carte uscite: ";
        for (int i = 0; i < rel.size(); i++)
            str += rel.get(i) + " ";
        str += "\nCarte generate: " + rel.size();
        return str;
    }
}