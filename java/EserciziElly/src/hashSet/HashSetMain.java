package hashSet;

import java.util.HashSet;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        System.out.println(set.size()); //0

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println(set.size()); //4

        set.add(5);

        System.out.println(set.size()); //5

        for(Integer i : set)
            System.out.print(i + " ");
        System.out.println();

        set.remove(1);

        System.out.println(set.size()); //4
    }
}
