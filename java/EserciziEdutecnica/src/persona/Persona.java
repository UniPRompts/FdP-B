package persona;

public class Persona {
    private final String nome;
    private final String cognome;
    private final String CF;

    public Persona(String nome, String cognome, String CF){
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getCF(){
        return CF;
    }

    @Override
    public String toString(){
        return nome + " " + cognome + " " + CF;
    }
}
