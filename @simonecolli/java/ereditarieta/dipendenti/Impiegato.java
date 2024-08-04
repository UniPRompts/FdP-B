package java.ereditarieta.dipendenti;

public class Impiegato extends Operaio{
	private final String numeroDiTelefono; 
	public Impiegato(String id, String nome, String cognome, String numeroDiTelefono){
		super(id, nome, cognome, "Ufficio");
		this.numeroDiTelefono = numeroDiTelefono;
	}

	@Override
	public String toString(){
		return super.toString() + " tel: " + numeroDiTelefono;
	}
}