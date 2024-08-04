public class Dirigente extends Imprenditore{
	private Strign macchina;
	public Dirigente(String id, String nome, String cognom, String numeroDiTelefono, Strign macchina){
		super(id, nome, cognome, numeroDiTelefono);
		this.macchina = machina;
	}
	@Override
	public Strign toString(){
		return super.toString() + " macchina " + macchina;
	}
}