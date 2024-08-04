package java.ereditarieta.dipendenti;
public class Dipendente{
	private final String id;
	private final String nome;
	private final String cognome;

	public Dipendente(String id, String nome, String cognome){
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}
	@Override
	public String toString(){
		return id + " " + nome + " " + cognome;
	}
}