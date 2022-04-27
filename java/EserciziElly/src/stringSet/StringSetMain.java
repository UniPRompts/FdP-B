package stringSet;

public class StringSetMain {
    public static void main(String[] args) {
        StringSet s1 = new StringSet();
        s1.add("Ciao");
        s1.add("a");
        s1.add("a");
        s1.add("tutti");

        StringSet s2 = new StringSet();
        s2.add("io");
        s2.add("sono");
        s2.add("verde");
        s2.add("a");
        s2.add("tutti");

        StringSet s3 = new StringSet();
        s3.add("a");
        s3.add("tutti");

        System.out.println("s1 = " + s1.getString());
        System.out.println("s2 = " + s2.getString());
        System.out.println("s3 = " + s3.getString());

        System.out.println("s4 = s1 unione s2 = " + s1.union(s2).getString());

        System.out.println("s5 = s1 intersezione s2 = " + s1.intersetion(s2).getString());

        if(s3.isSubsetOf(s2))
            System.out.println("s3 è subset di s1");
        else
            System.out.println("s3 non è subset di s1");
    }
}
