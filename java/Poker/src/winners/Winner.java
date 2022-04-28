package winners;
import cards.*;
import users.*;

public class Winner {
    /**
     * Ritorna quante volte una carte è presente nelle carte del dealer
     * @param card
     * @return
     */
    public static int getOccorrenze(Card card){
        int c = 0;

        for(int i = 0; i < Dealer.cards.size(); i++)
            if(card.getNumber() == Dealer.cards.get(i).getNumber())
                c++;

        return c;
    }
    /**
     * Ritorna un array contenente le occorrenze delle carte del dealer
     * @return
     */
    public static int [] getOccorrenzeDealer(){
        int[] c = new int[10];

        for(int i = 0; i < Dealer.cards.size(); i++){
            for(int j = 0; j < Dealer.cards.size(); j++){
                if(Dealer.cards.get(i).getNumber() == Dealer.cards.get(j).getNumber())
                    c[i]++;
            }
        }

        for(int i = 0; i < Dealer.cards.size(); i++)
            c[i]--;

        return c;
    }
    /**
     * Verifica se una carta è contenuta (tra le carte del dealer) esattamente value volte
     * @param value
     * @return
     */
    public static int countValue(int value){
        int[] c = getOccorrenzeDealer();
        int gg = 0;

        for(int i = 0; i < Dealer.cards.size(); i++)
            if(c[i] == value)
                gg++;

        return gg;
    }
    /**
     * Ritorna un array contenente le occorrenze delle carte
     * del dealer e dell'utente
     * @param user
     * @return
     */
    public static int[] getResultsToArray(User user){
        int[] counter = new int[14];

        counter[user.getC1().getNumber() - 1]++;
        counter[user.getC2().getNumber() - 1]++;

        if(user.getC1().getNumber() == 14) counter[0]++;
        if(user.getC2().getNumber() == 14) counter[0]++;

        for(int i = 0; i < Dealer.cards.size(); i++){
            if(Dealer.cards.get(i).getNumber() == 14) counter[0]++;
            counter[Dealer.cards.get(i).getNumber() - 1]++;
        }

        return counter;
    }
// ------------------------------------------------------------------------------ Dealer
    /**
     * Coppia Dealer
     * @return
     */
    public static boolean coppiaDealer(){
        return countValue(1) == 2;
    }
    /**
     * Tris Dealer
     * @return
     */
    public static boolean trisDealer(){
        return countValue(2) == 3;
    }
    /**
     * Doppia coppia Dealer
     * @return
     */
    public static boolean doppiaCoppiaDealer(){
        return countValue(1) == 4;
    }
    /**
     * Colore Dealer
     * @param counter
     */
    public static void coloreDealer(int[] counter){
        for(int i = 0; i < Dealer.cards.size(); i++)
            counter[Dealer.cards.get(i).getSuit()]++;
    }

    // ------------------------------------------------------------------------------ User
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

        //if(coppiaDealer() && coppia(user)) return true;
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
        return c1 == 2 || c2 == 2 || trisDealer();
    }
    /**
     * Poker
     * @param user
     * @return
     */
    public static boolean poker(User user){
        /*int c1 = getOccorrenze(user.getC1());
        int c2 = getOccorrenze(user.getC2());

        if(coppiaInMano(user) && (c1 == 2 || c2 == 2)) return true;
        return c1 == 3 || c2 == 3;*/
        int [] counter = getResultsToArray(user);

        for(int i = 0; i < counter.length; i++)
            if(counter[i] == 4)
                return true;
        return false;
    }
    /**
     * Colore
     * @param user
     * @return
     */
    public static boolean colore(User user){
        int []counter = new int[5];

        for(int i = 0; i < counter.length; i++)
            counter[i] = 0;

        counter[user.getC1().getSuit()]++;
        counter[user.getC2().getSuit()]++;

        coloreDealer(counter);

        for(int i = 0; i < counter.length; i++)
            if(counter[i] >= 5)
                return true;
        return false;
    }
    /**
     * Full
     * @param user
     * @return
     */
    public static boolean full(User user){
        int [] counter = getResultsToArray(user);
        boolean check1 = false;
        boolean check2 = false;

        for(int i = 0; i < counter.length; i++){
            if(counter[i] >= 2)
                if(counter[i] > 2)
                    check1 = true;
                else
                    check2 = true;
        }
        return check1 && check2;
    }
    /**
     * Scala
     * @param user
     * @return
     */
    public static boolean scala(User user){
        int [] counter = getResultsToArray(user);
        boolean check = true;

        for(int i = 0; i < counter.length - 5; i++){
            for(int j = 0; j < 5; j++)
                if(counter[i + j] < 1) check = false;
            if(check) return true;
            check = true;
        }
        return false;
    }
    /**
     * Scala reale
     * @param user
     * @return
     */
    public static boolean scalaReale(User user){
        int [] counter = getResultsToArray(user);
        boolean check = true;

        for(int i = 9; i < counter.length - 5; i++){
            for(int j = 0; j < 5; j++)
                if(counter[i + j] < 1) check = false;
            if(check) return true && colore(user);
            check = true;
        }
        return false;
    }


    /**
     * Effettua il controllo e l'assegnazione dei punti di un dato utente
     * @param user
     */
    public static void returnPoints(User user){
        if(scalaReale(user)){
            user.point = 1;
            //scala reale
        } else if(scala(user) && colore(user)){
            user.point = 2;
            //scala colore
        } else if(poker(user)){
            user.point = 3;
            //poker
        } else if(full(user)){
            user.point = 4;
            //full
        } else if(colore(user)){
            user.point = 5;
            //colore
        } else if(scala(user)){
            user.point = 6;
            //scala
        } else if(tris(user)){
            user.point = 7;
            //tris
        } else if(doppiaCoppia(user) || (coppia(user) && coppiaDealer()) || doppiaCoppiaDealer()){
            user.point = 8;
            //doppia coppia
        } else if(coppia(user) || coppiaDealer()) {
            user.point = 9;
            //coppia
        }
    }
}
