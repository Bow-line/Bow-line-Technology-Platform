import java.io.Serializable;

public class Message implements Serializable {
    private String content;
    private int number;

    public Message(String content) {
        this.content = content;
    }

    public Message(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
