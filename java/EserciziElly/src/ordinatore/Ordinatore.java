package ordinatore;

public class Ordinatore<T extends Comparable>  {
    private T obj;

    public Ordinatore(T obj){
        this.obj = obj;
    }

    public int check(T other) throws Exception {
        int result = this.obj.compareTo(other);
        System.out.print("Confronto tra " + obj + " e " + other + ": ");
        this.obj = other;
        return result;
    }

    public static void main(String[] args) throws Exception {
        Ordinatore<Integer> o1 = new Ordinatore<>(7);
        System.out.println(o1.check(1));
        System.out.println(o1.check(10));
        System.out.println(o1.check(10));

        Ordinatore<String> o2 = new Ordinatore<>("Ciao");
        System.out.println(o2.check("Come"));
        System.out.println(o2.check("Uva"));
        System.out.println(o2.check("Va"));
        System.out.println(o2.check("Va"));
    }
}
