package reverseString;

import java.util.Scanner;

public class ReverseString {
    public static String reverse(String s){
        String new_string = "";

        for(int i = s.length() - 1; i >= 0; i--)
           new_string += s.charAt(i);

        return new_string;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserire una stringa: ");
        String s = sc.nextLine();

        System.out.println("Reverse: " + reverse(s));
    }
}
