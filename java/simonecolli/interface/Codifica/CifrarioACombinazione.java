package Codifica;

public class CifrarioACombinazione implements CodificatoreMessaggio{
    private final int n;

    public CifrarioACombinazione(int n){
        this.n = n;
    }

    private String combina(char[] l, char[] r){
        String tmp = "";
        int c1 = 0, c2 = 0;
        boolean counter = true;
        while(c1 != l.length && c2 != r.length){
            if(counter){
                tmp += l[c1];
                c1++;
                counter = false;
            }else{
                tmp += r[c2];
                c2++;
                counter = true;
            }
        }

        while(c1 != l.length){
            tmp += l[c1];
                c1++;
        }
        while(c2 != r.length){
            tmp += r[c2];
            c2++;
        }

        return tmp;
    }
    @Override
    public String codifica(String testoInChiaro) {
        System.out.println(testoInChiaro);

        String tmp = "";
        int l1 = (int)(testoInChiaro.length()/2);
        int l2 = (int)(testoInChiaro.length() - l1);

        char[] A1 = new char[l1];
        char[] A2 = new char[l2];
        
        for(int i = 0; i < l1; i++)
            A1[i] = testoInChiaro.charAt(i);
        

        for(int i = 0; i < l2; i++)
            A2[i] = testoInChiaro.charAt(i + l1);
        
        // System.out.println("A1: " + String.valueOf(A1));
        // System.out.println("A2: " + String.valueOf(A2));

        for(int i = 0; i < n; i++)
            tmp = combina(A1, A2);
        
        return tmp;
    }
}
