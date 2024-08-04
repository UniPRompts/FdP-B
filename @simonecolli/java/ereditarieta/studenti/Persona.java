import java.util.Objects;

public class Persona{

    private final String nome;
    private final String cognome;
    private final String compleanno;

    public Persona(String nome, String cognome, String compleanno){
        this.nome = nome;
        this.cognome = cognome;
        this.compleanno = compleanno;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        return this.nome.equals(((Persona)obj).nome) && this.cognome.equals(((Persona)obj).cognome) && this.compleanno.equals(((Persona)obj).compleanno);
    }
    
        @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.cognome, this.compleanno);
    }

    @Override
    public String toString() {
        return compleanno + ": " + nome + " " + cognome;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Persona(this.nome, this.cognome, this.compleanno);
    }

}