package Codifica;
public class CodificaAScorrimento implements CodificatoreMessaggio{
    private final int key;
    public CodificaAScorrimento(int key){
        this.key = key;
    }

    @Override
    public String codifica(String testoInChiaro) {
        String tmp = "";

        for (int i = 0; i < testoInChiaro.length(); i++){
            tmp += (char)(testoInChiaro.charAt(i) + key);
        }
        return tmp;
    }
}
