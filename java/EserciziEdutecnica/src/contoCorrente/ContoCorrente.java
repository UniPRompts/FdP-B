package contoCorrente;
import persona.Persona;

import java.util.Set;
import java.util.HashSet;

/*
Esercizio 2
Crea un programma per la gestione di un controcorrente gestito dalla classe CC.
Il programma deve essere in grado di effettuare versamenti, prelievi, di restituire
    il saldo e di effettuare la lista degli ultimi 5 movimenti .
*/


public class ContoCorrente{
    private final Persona user;
    private Double saldo;
    private Set<Movimento> movimenti;

    public ContoCorrente(String nome, String cognome, String CF, Double saldoIniziale){
        user = new Persona(nome, cognome, CF);
        this.saldo = saldoIniziale;
        this.movimenti = new HashSet<>();
    }

    public void addMovimento(String tipoMovimento, Double cifra) throws
            SaldoNegativoException,
            TipoMovimentoNonRiconosciutoException,
            CifraNegativaException{
        Movimento tmp = new Movimento(tipoMovimento, cifra);

        if(tipoMovimento.equals("PRELIEVO")){
            if((saldo - cifra) < 0)
                throw new SaldoNegativoException();
            else
                this.saldo -= cifra;
        } else if(tipoMovimento.equals("VERSAMENTO"))
            this.saldo += cifra;

        movimenti.add(tmp);
    }

    @Override
    public String toString(){
        String mov = "";
        int i = 0;
        if(movimenti.size() > 5){
            for(Movimento m : movimenti){
                if(i > movimenti.size() - 6)
                    mov += "\n\t " + m.toString();
                i++;
            }
        }
        return "Conto corrente di: " + user.toString() +
                "\nSaldo: €" + this.saldo +
                "\nMovimenti: " + mov;
    }

}
