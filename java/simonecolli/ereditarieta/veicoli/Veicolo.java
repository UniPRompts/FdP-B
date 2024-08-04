public class Veicolo{
	private final String targa;
	private final String modello;
	private final String marca;
	private final int numeroPosti;

	public Veicolo(String targa, String modello, String marca, int numeroPosti){
		this.targa = targa;
		this.modello = modello;
		this.marca = marca;
		this.numeroPosti = numeroPosti;
	}


	public String getMarca(){
		return marca;
	}
	public String getTarga(){
		return targa;
	}
	public String getModello(){
		return modello;
	}
	public int getNumeroPosti(){
		return numeroPosti;
	}
	
	@Override
	public String toString(){
		return targa + " " + marca + " " + modello + " " + numeroPosti;
	}
}