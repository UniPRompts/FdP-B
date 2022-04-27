package cards;

public class Card {
    private int number; //from 2 to 14, 14: Ace
    /**
     * From 1 to 4
     * 1: diamonds
     * 2: clubs
     * 3: hearts
     * 4: spades
     */
    private int suit;

    /**
     * Costruttore
     */
    public Card(){
        this(0,0);
    }
    public Card(int number, int suit){
        this.number = number;
        this.suit = suit;
    }

    /**
     * Getter
     * @return
     */
    public int getNumber(){
        return this.number;
    }
    public int getSuit(){
        return this.suit;
    }

    /**
     * Setter
     */
    public void setSuit(int suit) {
        this.suit = suit;
    }
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Override metodo toString
     * @return
     */
    public String toString(){
        String str = "";

        switch (getSuit()){
            case 1: str += "\u2666 "; break;
            case 2: str += "\u2663 "; break;
            case 3: str += "\u2665 "; break;
            case 4: str += "\u2660 "; break;
        }

        switch (getNumber()){
            case 11: str += "J"; break;
            case 12: str += "Q"; break;
            case 13: str += "K"; break;
            case 14: str += "A"; break;
            default: str += getNumber(); break;
        }

        return str;
    }

}
