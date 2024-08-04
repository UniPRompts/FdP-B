package Gioco;
public class Licantropo implements Mostro, Umano{
	private int forza;

	public Licantropo(int forza){
		this.forza = forza;
	}
	@Override
	public void azzanna(){
		forza -= 2;
	}
	@Override
	public void attacca(){
		forza -= 3;
	}
	@Override
	public int getForza(){
		return forza;
	}
	public void lotta(boolean lunaPiena){
		if(lunaPiena)
			this.azzanna();
		else
			this.attacca();
	}
}