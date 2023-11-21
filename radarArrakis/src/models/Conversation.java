

import lombok.Getter;
import lombok.Setter;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Conversation implements Visitee {
    @Getter
    private List<Message> messageList;

    public Conversation(){
        messageList = new ArrayList<>();
    }

    public void print(){
        System.out.println("Conversation");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConversation(this);
    }
}