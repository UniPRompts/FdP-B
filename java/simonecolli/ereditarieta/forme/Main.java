public class Main {
    public static void main(String[] args) {
        Rettangolo r = new Rettangolo(10, 10);
        Quadrato q = new Quadrato(2);
        
        System.out.println(r.area());
        System.out.println(r.perimetro());
        
        System.out.println(q.area());
        System.out.println(q.perimetro());
        
        r.disegna();
        q.disegna();
        q.scale(2);
        q.disegna();
    }
}
