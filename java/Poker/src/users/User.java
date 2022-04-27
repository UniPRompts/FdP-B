package users;
import cards.*;

public class User {
    private Card c1;
    private Card c2;
    private String name;

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
