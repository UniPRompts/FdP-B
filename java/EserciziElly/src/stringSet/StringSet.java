package stringSet;

public class StringSet {
    private String[] s;

    //  Costructor vuoto inizializza a 0 elementi
    public StringSet(){
        s = new String[0];
    }

    // Get Size stringSet.StringSet
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
     * Unisce due stringSet.StringSet
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
     * Interseca due stringSet.StringSet
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
     * Verifica se this è subSet di un stringSet.StringSet dato
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
}
