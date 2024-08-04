public class AutoVeicolo extends Veicolo{

	private final int numeroPortiere;
	public AutoVeicolo(String targa, String modello, String marca, int numeroPosti, int numeroPortiere){
		super(targa, modello, marca, numeroPosti);
		this.numeroPortiere = numeroPortiere;
	}

	public int getNumeroPortiere(){
		return numeroPortiere;
	}

	@Override
	public String toString(){
		return super.toString() + " " + numeroPortiere;
	}
}