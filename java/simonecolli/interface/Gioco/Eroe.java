package Gioco;
public class Eroe implements Umano{
	private int forza;
	public Eroe(int forza){
		this.forza = forza;
	}
	@Override
	public void attacca(){
		forza -= 3;
	}
	@Override
	public int getForza(){
		return forza;
	}
}