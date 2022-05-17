package dadi;
import java.util.*;

public class DadoConMemoria implements Dado{
    private int value1, value2;
    public static int lanci;

    DadoConMemoria(){
        this.value1 = 0;
        this.value2 = 0;
        lanci = 0;
    }

    @Override
    public int lancio() {
        Random rand = new Random();
        int value;

        while(true){
            value = rand.nextInt(facce - 1) + 1;
            if(value != value1 && value != value2){

                lanci++;

                if(lanci % 2 == 0)
                    value2 = value;
                else
                    value1 = value;

                return value;
            }
        }
    }
}
