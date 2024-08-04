package Codifica;
public class Main {
    public static void main(String[] args) {
        // CodificaAScorrimento c = new CodificaAScorrimento(3);
        // System.out.println(c.codifica("abz"));
        CifrarioACombinazione c = new CifrarioACombinazione(2);
        System.out.println(c.codifica("abcdefghi"));
    }
}
