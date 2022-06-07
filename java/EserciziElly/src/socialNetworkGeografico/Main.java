package socialNetworkGeografico;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void stampaBacheca(StatusMessage s, HashSet<StatusMessage> messages){
        System.out.println("Bacheca di " + s.getUsername() + " a " + s.getCity());

        for(StatusMessage sn : messages)
            if(s.isNearTo(sn))
                System.out.println(sn);
    }


    public static void main(String[] args) {
        StatusMessage s1 = new StatusMessage("Michele Rossi", "Bologna", "pensa che oggi non può andare peggio di ieri.");
        StatusMessage s2 = new StatusMessage("Aldo Blu", "Milano", "si diverte un sacco!");
        StatusMessage s3;

        Scanner sc = new Scanner(System.in);

        System.out.print("Inserire username: ");
        String username = sc.nextLine();
        System.out.print("Inserire la citta': ");
        String city = sc.nextLine();
        System.out.print("Inserire il testo: ");
        String text = sc.nextLine();

        s3 = new StatusMessage(username, city, text);

        HashSet<StatusMessage> messages = new HashSet<>();
        messages.add(s1);
        messages.add(s2);
        messages.add(s3);

        stampaBacheca(s3, messages);
    }
}
