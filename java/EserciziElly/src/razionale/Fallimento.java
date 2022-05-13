package razionale;

import java.io.*;

public class Fallimento extends Exception{

    public static void main(String[] args) throws IOException {
        char x = (char) System.in.read();
        char y = (char) System.in.read();
        char z = (char) System.in.read();

        System.out.println(x + y + z);
    }
}

