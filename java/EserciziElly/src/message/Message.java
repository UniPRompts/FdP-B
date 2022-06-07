package message;

public class Message {
    protected String sender;
    protected String receiver;
    protected String text;

    public Message(String sender, String receiver, String text){
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }
}
