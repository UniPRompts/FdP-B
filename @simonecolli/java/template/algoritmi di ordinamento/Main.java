public class Main{
    public static void main(String[] args) {
        // Cards[] array = {
        //     new Cards("contenuto 0"), new Cards("contenuto 1"),
        //     new Cards("contenuto 2"), new Cards("contenuto 3"), 
        // };
        // Cards tmp  = array[0];
        // array[0] = array[3];
        // array[3] = tmp;

        // for (Cards card : array) {
        //     System.out.println(card);
            
        // }
        // Sort<Cards> b = new Sort<Cards>(array, array.length);
        // b.increasingSelectionSort();
        // System.out.println(b);


        Integer[] numbers = {4, 3, 2, 1, 0};
        for (Integer i : numbers) 
            System.out.print(i + " ");
        System.out.println("");

        Sort<Integer> s = new Sort<Integer>(numbers, numbers.length);
        s.increasingBubbleSort();
        System.out.println(s);
        s.decreasingBubbleSort();
        System.out.println(s);
        
        s.increasingSelectionSort();
        System.out.println(s);
        s.decreasingSelectionSort();
        System.out.println(s);

        s.increasingInsectionSort();
        System.out.println(s);
        s.decreasingInsectionSort();
        System.out.println(s);
    }
        
}
