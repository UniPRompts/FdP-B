package cassaforte;
/**
 * Si implementi in Java la classe Cassaforte, che rappresenta una cassaforte che contiene una stringa segreta,
 * protetta da un numero intero che funge da combinazione per aprire la cassaforte e rilevare la stringa segreta.
 * Il costruttore prende come parametri la stringa segreta e la combinazione.
 * Il metodo open accetta un numero intero e restituisce la stringa segreta se tale numero coincide con la combinazione.
 * Altrimenti, restituisce null.
 * Se le ultime 3 chiamate a open falliscono, la cassaforte diventa irreversibilmente bloccata ed ogni ulteriore chiamata
 * ad open solleva un'eccezione (throw new RuntimeException()).
 */

public class Cassaforte {
    private String parolaSegreta;
    private int codiceSegreto;
    public static int attempts;

    /**
     * Costruttore
     * @param parolaSegreta
     * @param codiceSegreto
     */
    public Cassaforte(String parolaSegreta, int codiceSegreto){
        this.parolaSegreta = parolaSegreta;
        this.codiceSegreto = codiceSegreto;
        attempts = 0;
    }

    /**
     * Getter
     * @return
     */
    public int getCodiceSegreto() {
        return codiceSegreto;
    }
    public String getParolaSegreta() {
        return parolaSegreta;
    }

    /**
     * Il metodo open accetta un numero intero e restituisce la stringa
     * segreta se tale numero coincide con la combinazione.
     * Altrimenti, restituisce null.
     * @param combinazione
     * @return
     */
    public String open(int combinazione){
        if(attempts < 3){
            if(combinazione == getCodiceSegreto())
                return getParolaSegreta();
            attempts++;
            if(attempts == 3){
                throw new RuntimeException();
            }
        }
        return null;
    }
}
