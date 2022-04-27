package contoCorrente;

public class ContoCorrente {
    private String name;
    private String lastName;
    private int id;
    private double balance;

    private static int allocs = 0;

    /**
     * Costruttore che genera id in modo incrementale
     * @param name nome
     * @param lastName cognome
     * @param balance saldo iniziale
     */
    public ContoCorrente(String name, String lastName, double balance){
        this.name = name;
        this.lastName = lastName;
        this.balance = balance;
        this.id = 1000 + allocs;
        allocs++;
    }

    /**
     * Getter
     * @return
     */
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }

    /**
     * Setter
     * @param balance nuovo saldo
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Override metodo toString
     * @return stringa contenente dati conto corrente
     */
    public String toString(){
        String data = "";

        data += "Name: " + getName();
        data += "\nLast Name: " + getLastName();
        data += "\nId account: " + getId();
        data += "\nBalance: €" + getBalance();
        data += "\n";

        return data;
    }

    /**
     * Metodo che effettua il deposito
     * @param money
     */
    public void deposit(double money){
        setBalance(getBalance() + money);
    }

    /**
     * Metodo che effettua il prelievo
     * @param money
     * @return true se il prelievo è andato a buon fine, false altrimenti
     */
    public boolean withdraw(double money){
        if((getBalance() - money) < 0)
            return false;
        setBalance(getBalance() - money);
        return true;
    }

    /**
     * Effettua bonifico da un conto corrente ad un altro
     * @param other conto corrente beneficiario
     * @param money quantità di soldi da inviare
     * @return true se il bonifico è andato a buon fine, false altrimenti
     */
    public boolean sendTo(ContoCorrente other, double money){
        if(!withdraw(money))
            return false;
        other.deposit(money);
        return true;
    }
}
