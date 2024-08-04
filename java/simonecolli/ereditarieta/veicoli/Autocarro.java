public class Autocarro extends Veicolo{
	
	private final int portataMassima;
	public Autocarro(String targa, String modello, String marca, int numeroPosti, int portataMassima){
		super(targa, modello, marca, numeroPosti);
		this.portataMassima = portataMassima;
	}

	public int getPortataMassima(){
		return portataMassima;
	}

	@Override
	public String toString(){
		return super.toString() + " " + portataMassima;
	}

}