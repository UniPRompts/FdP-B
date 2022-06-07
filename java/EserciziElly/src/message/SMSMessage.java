package message;

public class SMSMessage extends Message implements ValidateAddess {
    private int progressiveID;

    public SMSMessage(String sender, String receiver, String text, int proressiveID){
        super(sender, receiver, text);
        this.progressiveID = proressiveID;
    }

    @Override
    public int validateAddress() {
        boolean sen = false;
        boolean rec = false;

        try {
            int n1 = Integer.parseInt(sender);
        } catch (NumberFormatException nfe) {
            sen = true;
        }

        try {
            int n1 = Integer.parseInt(receiver);
        } catch (NumberFormatException nfe) {
            rec = true;
        }

        if(sen && rec) return 3;
        if(sen) return 1;
        if(rec) return 2;
        return 0;
    }

    @Override
    public String toString(){
        String result = "Messaggio " + progressiveID + ": ";

        if(validateAddress() == 0)
            result += "OK";
        else
            result += "Errore tipo " + validateAddress();

        return result;
    }
}
