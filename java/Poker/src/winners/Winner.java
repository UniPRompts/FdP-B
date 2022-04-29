package winners;
import cards.*;
import users.*;

public class Winner {
    public static int [] counter;
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
     * Colore Dealer
     * @param color
     */
    public static void coloreDealer(int[] color){
        for(int i = 0; i < Dealer.cards.size(); i++)
            color[Dealer.cards.get(i).getSuit()]++;
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
     * @return
     */
    public static boolean coppia(){
        for(int i = 0; i < counter.length; i++)
            if(counter[i] == 2)
                return true;
        return false;

    }
    /**
     * Doppia coppia
     * @return
     */
    public static boolean doppiaCoppia(){
        boolean check1 = false;
        boolean check2 = false;

        for(int i = 0; i < counter.length; i++){
            if(i != 0){
                if(counter[i] == 2)
                    if(!check1)
                        check1 = true;
                    else
                        check2 = true;
            }

        }
        return check1 && check2;
    }
    /**
     * Tris
     * @return
     */
    public static boolean tris(){
        for(int i = 0; i < counter.length; i++)
            if(counter[i] == 3)
                return true;
        return false;
    }
    /**
     * Poker
     * @return
     */
    public static boolean poker(){
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
        int []color = new int[5];

        for(int i = 0; i < color.length; i++)
            color[i] = 0;

        color[user.getC1().getSuit()]++;
        color[user.getC2().getSuit()]++;

        coloreDealer(color);

        for(int i = 0; i < color.length; i++)
            if(color[i] >= 5)
                return true;
        return false;
    }
    /**
     * Full
     * @return
     */
    public static boolean full(){
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
     * @return
     */
    public static boolean scala(){
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

        counter = getResultsToArray(user);

        if(scalaReale(user)){
            user.point = 1;
        } else if(scala() && colore(user)){
            user.point = 2;
        } else if(poker()){
            user.point = 3;
        } else if(full()){
            user.point = 4;
        } else if(colore(user)){
            user.point = 5;
        } else if(scala()){
            user.point = 6;
        } else if(tris()){
            user.point = 7;
        } else if(doppiaCoppia()){
            user.point = 8;
        } else if(coppia()) {
            user.point = 9;
        } else{
            user.point = 10;
        }
    }
}
