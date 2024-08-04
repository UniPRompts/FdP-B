package Gioco;
public class Vampiro implements Mostro{

	private int forza;

	public Vampiro(int forza){
		this.forza = forza;
	}

	@Override
	public void azzanna(){
		forza -= 2;
	}
	@Override
	public int getForza(){
		return forza;
	}
}