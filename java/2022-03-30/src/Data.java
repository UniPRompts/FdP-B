import java.util.*;
public class Data {
    private int giorno;
    private int mese;
    private int anno;

    private boolean valida(int giorno, int mese, int anno) {
        if(giorno < 1 || giorno > 31)
            return false;
        if(mese < 1 || mese > 12)
            return false;
        if(anno < 1)
            return false;
        return true;

    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Data() {
        this.anno = 1970;
        this.mese = 1;
        this.giorno = 1;
    }
    public Data(int giorno, int mese, int anno) {
        if(valida(giorno, mese, anno)) {
            this.anno = anno;
            this.giorno = giorno;
            this.mese = mese;
        } else {
            System.err.println("Formato data non valido");
            this.anno = 1970;
            this.mese = 1;
            this.giorno = 1;
        }

    }

    public void print() {
        System.out.println(getGiorno() + "/" + getMese() + "/" + getAnno());
    }

    public static void main(String[] args) {
        Data d1 = new Data();
        Data d2 = new Data(30,4,2002);

        d1.print();
        d2.print();
        return;
    }
}
