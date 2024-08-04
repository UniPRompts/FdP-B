public class Voto{
    private final String corso;
    private final float voto;
    private final int CFU;

    public Voto(String corso, float voto, int CFU){
        this.corso = corso;
        this.voto = voto;
        this.CFU = CFU;
    }

    @Override
    public String toString() {
        return "- " + corso + ": " + voto + " <-> " + CFU;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((corso == null) ? 0 : corso.hashCode());
        result = prime * result + Float.floatToIntBits(voto);
        result = prime * result * CFU;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Voto other = (Voto) obj;
        return this.corso.equals(other.corso) && this.voto == other.voto && this.CFU == other.CFU;
    }

    public int getCFU() {
        return CFU;
    }
    public String getCorso() {
        return corso;
    }
    public float getVoto() {
        return voto;
    }
}
