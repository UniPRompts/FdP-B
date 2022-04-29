package users;
import cards.*;

public class User {
    private Card c1;
    private Card c2;
    private String name;

    /**
     * Valori variabile
     * 0: init
     * 1: scala reale
     * 2: scala colore
     * 3: poker
     * 4: full
     * 5: colore
     * 6: scala
     * 7: tris
     * 8: doppia coppia
     * 9: coppia
     * 10: carta alta
     */
    public int point;
    public int maxValuePoint;

    /**
     * Costruttori
     */
    public User(String name){
        this(name, null, null);
    }
    public User(String name, Card c1, Card c2){
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
        this.point = 99; // inizializzato a null
        this.maxValuePoint = 0;
    }

    /**
     * Getter
     * @return
     */
    public Card getC1() {
        return c1;
    }
    public Card getC2() {
        return c2;
    }
    public String getName() {
        return name;
    }
    public String getPointToString(){
        String str = "";

        switch(point){
            case 1:
                str = "Scala Reale";
                break;

            case 2:
                str = "Scala Colore";
                break;

            case 3:
                str = "Poker";
                break;

            case 4:
                str = "Full";
                break;

            case 5:
                str = "Colore";
                break;

            case 6:
                str = "Scala";
                break;

            case 7:
                str = "Tris";
                break;

            case 8:
                str = "Doppia Coppia";
                break;

            case 9:
                str = "Coppia";
                break;

            case 10:
                str = "Carta Alta";
                break;
        }

        return str;
    }

    /**
     * Setter
     * @param c1
     */
    public void setC1(Card c1) {
        this.c1 = c1;
    }
    public void setC2(Card c2) {
        this.c2 = c2;
    }

    /**
     * Override metodo toString
     * @return
     */
    public String toString(){
        return "" + name + ": " + getC1() + " " + getC2();
    }

    public void generateCards(){
        setC1(GenerateCard.generate());
        setC2(GenerateCard.generate());
    }
}
