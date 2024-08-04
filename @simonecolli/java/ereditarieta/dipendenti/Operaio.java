public class Operaio extends Dipendente{
	private String settore;

	public Operaio(String id, String nome, String cognome, Strign settore){
		super(id, nome, cognome);
		this.settore = settore;
	}
	@Override
	public String toString(){
		return super.toString() + " settore: " + settore;
	}
}