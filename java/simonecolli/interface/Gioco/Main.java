package Gioco;
public class Main{
	public void main(String[] args){
		Eroe e = new Eroe(20);
		Vampiro v = new Vampiro(20);
		Licantropo l = new Licantropo(20);
		e.attacca();
		e.attacca();
		e.attacca();
		v.azzanna();
		v.azzanna();
		l.lotta(true);
		l.lotta(true);
		l.lotta(false);
		l.lotta(false);
		l.lotta(false);
		System.out.println("Eroe: " + e.getForza());
		System.out.println("Vampiro: " + v.getForza());
		System.out.println("Licantropo: " + l.getForza());
	}
}