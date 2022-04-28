package myString;

/**
 * Si implementi in Java la classe MyString, che rappresenta una stringa.
 * Si implementi la seguente specifica per il metodo equals:
 * due oggetti della classe MyString sono considerati uguali se sono uno l'anagramma dell'altro.
 * Si implementi una classe MainMyString contenente un main di prova per la classe MyString.
 * Entrambe le classi devono far parte del package it.unipr.mystring.
 */

public class MyString {
    private String str;

    /**
     * Costruttore
     */
    public MyString(){
        this(null);
    }
    public MyString(String str){
        this.str = new String(str);
    }

    /**
     * Getter
     * @return
     */
    public String getStr(){
        return this.str;
    }

    /**
     * Override metodo equals
     * @param other
     * @return
     */
    public boolean equals(MyString other){
        if(getStr().compareTo(other.getStr()) == 0)
            return true;
        return false;
    }
}
