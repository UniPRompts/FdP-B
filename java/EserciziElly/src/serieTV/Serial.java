package serieTV;

import java.util.HashSet;

public class Serial {
    private HashSet<Episode> serie = new HashSet<Episode>();
    private String titolo;

    public Serial(String titolo){
        this.titolo = titolo;
    }

    public void add(Episode ep){
        serie.add(ep);
        System.out.println(ep);
    }

    public int numeroEpisodi(){
        return serie.size();
    }

    @Override
    public String toString(){
        String str = "Titolo serie tv: " + titolo;

        for(Episode i : serie)
            str += i.toString();

        return str;
    }
}
