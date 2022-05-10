package lavoratore;

public class LavoratoreConStraordinari extends Lavoratore{
    private int oreStraordinario;
    private static final float RETRIBUZIONE_ORARIA = (float) 10.5;

    public LavoratoreConStraordinari(String nome, String cognome, int livello, int stipendio, int oreStraordinario){
        super(nome, cognome, livello, stipendio);
        this.oreStraordinario = oreStraordinario;
    }

    public float getStipendio(){
        return (float) RETRIBUZIONE_ORARIA * oreStraordinario + super.getStipendio();
    }

    public static void main(String[] args) {
        LavoratoreConStraordinari l1 = new LavoratoreConStraordinari("Ugo", "Foscolo", 5, 2000, 3);
        LavoratoreConStraordinari l2 = new LavoratoreConStraordinari("Javier", "Zanetti", 5, 1500, 10);

        System.out.println(l1);
        System.out.println(l2);
    }
}
