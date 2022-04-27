package intList;

public class IntList {
    private Elem list;
    private int n; // lunghezza

    /**
     * Costruttore
     */
    public IntList(){
        this.list = null;
        this.n = 0;
    }

    /**
     * Getter
     * @return
     */
    public int size(){
        return this.n;
    }

    /**
     * Inserisce un nuovo elemento in testa
     * @param value valore elemento da inserire
     */
    public void addFirst(int value){
        Elem new_elem = new Elem(value, list);
        list = new_elem;
        this.n++;
    }
    /**
     * Inserisce un nuovo elemento in coda
     * @param value valore elemento da inserire
     */
    public void addLast(int value){
        Elem new_elem = new Elem(value);
        Elem temp = list;

        for(int i = 0; i < n - 1; i++)
            temp = temp.getNext();

        temp.setNext(new_elem);
        this.n++;
    }

    /**
     * Rimuove un elemento dalla testa
     * @return valore elemento
     */
    public int removeFirst(){
        if(list == null)
            throw new RuntimeException();
        int value = list.getValue();

        list = list.getNext();
        this.n--;

        return value;
    }
    /**
     * Rimuove un elemento dalla coda
     * @return valore elemento
     */
    public int removeLast(){
        Elem temp = list;

        for(int i = 0; i < n - 1; i++)
            temp = temp.getNext();

        this.n--;
        return temp.getValue();
    }

    /**
     * Controlla se un valore è contenuto in una lista
     * @param value valore da cercare
     * @return true se è contenuto, false altrimenti
     */
    public boolean contains(int value){
        Elem temp = list;
        for(int i = 0; i < n; i++){
            if(value == temp.getValue())
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    /**
     * Override metodo toString
     * @return
     */
    public String toString(){
        String str = "";

        Elem temp = list;

        for(int i = 0; i < n; i++){
            str += temp.getValue() + " ";
            temp = temp.getNext();
        }

        return str;
    }
}
