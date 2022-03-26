package co.edu.escuelaing.arsw.chatserver.controller;

import co.edu.escuelaing.arsw.chatserver.controller.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // Create dynamic topics
    private SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/message") // /app/message -> Frontend target url
    @SendTo("/chatroom/public")
    public Message receivePublicMessages(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessages(@Payload Message message){
        // This uses the setUserDestinationPrefix on WebSocketConfig
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message); // LISTEN: /user/USERNAME/private
        System.out.println("--- MESSAGE ---");
        System.out.println(message);
        return message;
    }

}
