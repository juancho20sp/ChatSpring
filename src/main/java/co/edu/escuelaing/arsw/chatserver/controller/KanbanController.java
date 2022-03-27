package co.edu.escuelaing.arsw.chatserver.controller;

import co.edu.escuelaing.arsw.chatserver.controller.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class KanbanController {

    // Create dynamic topics
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/newCard")
    public Card newCard(@Payload Card card) {
        System.out.println("--- CARD ---");
        System.out.println("--- newCard ---");
        System.out.println(card.getRoomId());
        System.out.println(card.toString());

        simpMessagingTemplate.convertAndSendToUser(card.getRoomId(), "/newCard", card);
        return card;
    }

    @MessageMapping("/cardClicked")
    public Card clickCard(@Payload Card card){
        // $
        System.out.println("CARD CLICKED");
        System.out.println(card);


        simpMessagingTemplate.convertAndSendToUser(card.getRoomId(), "/cardClicked", card);
        System.out.println("--- CARD ---");
        System.out.println("--- clickCard ---");
        System.out.println(card.toString());
        return card;
    }

//    @MessageMapping("/private-message")
    @MessageMapping("/moveCard")
    public Card moveCard(@Payload Card card){
        // This uses the setUserDestinationPrefix on WebSocketConfig
        simpMessagingTemplate.convertAndSendToUser(card.getRoomId(), "/moveCard", card); // LISTEN: /user/USERNAME/private
        System.out.println("--- CARD ---");
        System.out.println("--- moveCard ---");
        System.out.println(card.toString());
        return card;
    }



}
