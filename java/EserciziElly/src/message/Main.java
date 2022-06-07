package message;

public class Main {
    public static void main(String[] args) {
        SMSMessage m1 = new SMSMessage("1234", "2345", "Ciao bello", 1);
        SMSMessage m2 = new SMSMessage("1234w", "2345", "Come stai", 2);

        System.out.println(m1);
        System.out.println(m2);
    }
}
