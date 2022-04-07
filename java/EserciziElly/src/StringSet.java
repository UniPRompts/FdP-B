public class StringSet {
    private String[] s;

    //  Costructor vuoto inizializza a 0 elementi
    public StringSet(){
        s = new String[0];
    }

    // Get Size StringSet
    public int size(){
        return s.length;
    }

    // Get String
    public String getString(){
        String result = "{";

        for(int i = 0; i < size(); i++){
            result += s[i];
            if(i != size() - 1)
                result += ", ";
        }

        result += "}";

        return result;
    }

    /**
     * Inserisce un nuovo elemento (se non già presente) al set
     * @param other elemento da aggiungere al set
     */
    public void add(String other){
        if(!contains(other)){
            String[] new_s = new String[size() + 1];

            for(int i = 0; i < size(); i++)
                new_s[i] = s[i];

            new_s[size()] = other;

            this.s = new_s;
        }
    }

    /**
     * Controlla se un elemento è presente nel set
     * @param other elemento da cercare
     * @return true se è contenuto, false altrimenti
     */
    public boolean contains(String other){
        for(int i = 0; i < size(); i++)
            if(s[i].equals(other))
                return true;
        return false;
    }

    /**
     * Unisce due StringSet
     * @param other
     * @return risultato unione
     */
    public StringSet union(StringSet other){
        StringSet result = new StringSet();

        for(int i = 0; i < this.size(); i++)
            result.add(this.s[i]);
        for(int i = 0; i < other.size(); i++)
            result.add(other.s[i]);

        return result;
    }

    /**
     * Interseca due StringSet
     * @param other
     * @return risultato intersezione
     */
    public StringSet intersetion(StringSet other){
        StringSet result = new StringSet();

        for(int i = 0; i < this.size(); i++)
            if(other.contains(s[i]))
                result.add(s[i]);

        return result;
    }

    /**
     * Verifica se this è subSet di un StringSet dato
     * @param other
     * @return true se è subset, false altrimenti
     */
    public boolean isSubsetOf(StringSet other){
        if(this.size() >= other.size())
            return false;

        for(int i = 0; i < this.size(); i++)
            if(!other.contains(s[i]))
                return false;

        return true;
    }

    public static void main(String[] args) {
        StringSet s1 = new StringSet();
        s1.add("Ciao");
        s1.add("a");
        s1.add("a");
        s1.add("tutti");

        StringSet s2 = new StringSet();
        s2.add("io");
        s2.add("sono");
        s2.add("verde");
        s2.add("a");
        s2.add("tutti");

        StringSet s3 = new StringSet();
        s3.add("a");
        s3.add("tutti");

        System.out.println("s1 = " + s1.getString());
        System.out.println("s2 = " + s2.getString());
        System.out.println("s3 = " + s3.getString());

        System.out.println("s4 = s1 unione s2 = " + s1.union(s2).getString());

        System.out.println("s5 = s1 intersezione s2 = " + s1.intersetion(s2).getString());

        if(s3.isSubsetOf(s2))
            System.out.println("s3 è subset di s1");
        else
            System.out.println("s3 non è subset di s1");
    }
}
