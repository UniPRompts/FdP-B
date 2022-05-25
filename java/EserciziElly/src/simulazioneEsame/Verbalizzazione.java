package simulazioneEsame;

public class Verbalizzazione {
    private final Studente studente;
    private final int esito;

    public Verbalizzazione(Studente studente , int esito) {
        this.studente = studente;
        if (esito < 0 || esito > 30)
            throw new RuntimeException();
        this.esito = esito;
    }
    public Studente getStudente() { return studente; }
    public int getEsito() { return esito; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Verbalizzazione other = (Verbalizzazione) obj;
        return esito == other.getEsito() && studente.equals(other.getStudente());
    }

    @Override
    public int hashCode() {
        return getEsito() + 31 * getStudente().hashCode();
    }
    @Override
    public String toString() {
        return studente.toString() + " voto: " + esito;
    }
}