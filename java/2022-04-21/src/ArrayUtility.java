public class ArrayUtility<T> {
    public static <T> boolean compare(T[] a, T[] b){
        if(a.length != b.length)
            return false;
        for(int i = 0; i < a.length; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }

    public static <T> boolean search(T[] a, T value){
        for(int i = 0; i < a.length; i++)
            if(a[i].equals(value))
                return true;
        return false;
    }

    public static void sort(Integer[] a){
        for(int i = 0; i < a.length; i++)
            for(int j = a.length - 1; j > i; j--)
                if(a[j] < a[j - 1])
                    Utility.swap(a, j, j - 1);
    }

    public static <T> String toString(T[] a){
        String str = "";
        for(int i = 0; i < a.length; i++)
            str += a[i] + " ";
        return str;
    }
}
