package lavoratore;

public class Lavoratore {
    protected String nome;
    protected String cognome;
    protected int livello;
    protected int stipendio;

    private static final float SALARIO_MINIMO = 1500;

    public Lavoratore(String nome, String cognome, int livello, int stipendio){
        this.nome = nome;
        this.cognome = cognome;
        if(stipendio < SALARIO_MINIMO)
            throw new RuntimeException("Stipendio inferiore al salario minimo");
        this.stipendio = stipendio;
        this.livello = livello;
    }

    public float getStipendio(){
        return this.stipendio;
    }

    public String toString(){
        return "Nome: " + nome + "\nCognome: " + cognome + "\nLivello: " + livello + "\nStipendio: " + getStipendio();
    }
}
