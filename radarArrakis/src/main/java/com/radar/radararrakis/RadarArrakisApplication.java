package com.radar.radararrakis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import messages.json;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class RadarArrakisApplication {


    public static void main(String[] args) throws IOException {
//		SpringApplication.run(RadarArrakisApplication.class, args);
        var messages = new ObjectMapper().readValue(
                new URL("file:src/messages.json"),
                new TypeReference<List<Message>>(){});
        Conversation conversation = new Conversation();

        for (Message message: messages) {
            conversation.getMessageList().add(message);
        }

        RenderContentVisitor visitor = new RenderContentVisitor();
        conversation.accept(visitor);

    }
}
