package list;

public class List<T> {
    private Elem<T> list;
    private int n; // lunghezza

    /**
     * Costruttore
     */
    public List(){
        this.list = null;
        this.n = 0;
    }

    /**
     * Getter size
     * @return size
     */
    public int size(){
        return this.n;
    }
    /**
     * Getter ultimo elemento
     * @return ultimo elemento
     */
    public Elem<T> getLastElement(){
        Elem<T> temp = list;
        for(int i = 0; i < n - 1; i++)
            temp = temp.getNext();
        return temp;
    }
    /**
     * Getter elemento scelto da utente tramite indice
     * @param index indice
     * @return elemento voluto
     */
    public T getValue(int index){
        if(index >= n || list == null)
            throw new RuntimeException();

        Elem<T> temp = list;
        for(int i = 0; i < index - 1; i++)
            temp = temp.getNext();

        return temp.getValue();

    }

    /**
     * Inserisce un nuovo elemento in testa
     * @param value valore elemento da inserire
     */
    public void addFirst(T value){
        Elem<T> new_elem = new Elem(value, list);
        list = new_elem;
        this.n++;
    }
    /**
     * Inserisce un nuovo elemento in coda
     * @param value valore elemento da inserire
     */
    public void addLast(T value){
        getLastElement().setNext(new Elem(value));
        this.n++;
    }

    /**
     * Rimuove un elemento dalla testa
     * @return valore elemento
     */
    public T removeFirst(){
        if(list == null)
            throw new RuntimeException();

        T value = list.getValue();
        list = list.getNext();
        this.n--;

        return value;
    }
    /**
     * Rimuove un elemento dalla coda
     * @return valore elemento
     */
    public T removeLast(){
        if(list == null)
            throw new RuntimeException();

        this.n--;
        return getLastElement().getValue();
    }

    /**
     * Controlla se un valore è contenuto in una lista
     * @param value valore da cercare
     * @return true se è contenuto, false altrimenti
     */
    public boolean contains(T value){
        Elem<T> temp = list;
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
