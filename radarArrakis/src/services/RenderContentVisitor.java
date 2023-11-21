
import jakarta.servlet.http.PushBuilder;
import models.Conversation;
import models.Message;
import models.Visitor;

public class RenderContentVisitor implements Visitor<Void> {
    @Override
    public Void visitMessage(Message message) {
        message.print();
        return null;
    }

    public Void visitConversation(Conversation conversation){
        conversation.print();
        for (Message message: conversation.getMessageList()) {
            message.accept(this);
        }
        return  null;
    }
}