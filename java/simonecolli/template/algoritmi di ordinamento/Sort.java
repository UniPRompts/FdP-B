public class Sort<T extends Comparable<T>>{
    
    private T[] orderedArray;
    private int length;
    
    public Sort(T[] array, int length){
        
        this.length = length;
        
        this.orderedArray = array;
    }

    public void increasingBubbleSort(){
        for(int i = 0; i < length-1; i++){
            for (int j = 0; j < length-i-1 ; j++) {
                if(orderedArray[j].compareTo(orderedArray[j+1]) > 0){
                    T tmp = orderedArray[j+1];
                    orderedArray[j+1] = orderedArray[j];
                    orderedArray[j] = tmp;
                }
            }
        }
    }
    public void decreasingBubbleSort(){
        for(int i = 0; i < length-1; i++){
            for (int j = 0; j < length-i-1 ; j++) {
                if(orderedArray[j].compareTo(orderedArray[j+1]) < 0){
                    T tmp = orderedArray[j+1];
                    orderedArray[j+1] = orderedArray[j];
                    orderedArray[j] = tmp;
                }
            }
        }
    }

    
    public void increasingSelectionSort(){
        for (int i = 0; i < length - 1; i++) {
            int tmpCursor = i;
            for (int j = i+1; j < length; j++) {
                if(orderedArray[j].compareTo(orderedArray[tmpCursor]) < 0)
                    tmpCursor = j;
            }
            T tmp = orderedArray[i];
            orderedArray[i] = orderedArray[tmpCursor];
            orderedArray[tmpCursor] = tmp;
        }
    }
    public void decreasingSelectionSort(){
        for (int i = length-1; i > 1; i--) {
            int tmpCursor = i;
            for (int j = i - 1; j >= 0; j--) {
                if(orderedArray[j].compareTo(orderedArray[tmpCursor]) < 0)
                    tmpCursor = j;
            }
            T tmp = orderedArray[i];
            orderedArray[i] = orderedArray[tmpCursor];
            orderedArray[tmpCursor] = tmp;
        }
    }




    public void increasingInsectionSort(){
        for (int i = 1; i < length; i++) {
            T tmp = orderedArray[i];
            int j = i - 1;
            while(j >= 0 && (orderedArray[j].compareTo(tmp) > 0)){
                orderedArray[j + 1] = orderedArray[j];
                j--;
            }
            orderedArray[j + 1] = tmp;
        }
    }

    public void decreasingInsectionSort(){
        for (int i = 1; i < length; i++) {
            T tmp = orderedArray[i];
            int j = i - 1;
            while(j >= 0 && (orderedArray[j].compareTo(tmp) < 0)){
                orderedArray[j + 1] = orderedArray[j];
                j--;
            }
            orderedArray[j + 1] = tmp;
        }
    }




    
    @Override
    public String toString() {
        String tmp = "{\n";
        tmp += "Ordered array: ";
        for (int i = 0; i < length; i++) {
            tmp += orderedArray[i].toString() + " ";
        }
        tmp += "\n}";
        return tmp;
    }
}
