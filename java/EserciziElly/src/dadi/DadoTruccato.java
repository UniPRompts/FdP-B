package dadi;

import java.util.Random;

public class DadoTruccato implements Dado{


    @Override
    public int lancio() {
        Random rand = new Random();

        int value = rand.nextInt(facce + 4) + 1;

        if(value > facce) return 5;
        return value;
    }
}
