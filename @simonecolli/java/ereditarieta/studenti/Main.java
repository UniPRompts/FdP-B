public class Main {
    public static void main(String[] args) {
        Studente st = new Studente("Simone", "Colli", "12/09/2002");
        System.out.println(st);
        
        st.addVoto(new Voto("Programmazione", 33, 14));
        st.addVoto(new Voto("Analisi", 27, 6));
        
        System.out.println(st);
    }
}
