package myString;

public class MyStringMain {
    public static void main(String[] args) {
        MyString str = new MyString("Ciao");
        MyString str2 = new MyString("ciao");

        System.out.println(str.equals(str2));
    }
}
