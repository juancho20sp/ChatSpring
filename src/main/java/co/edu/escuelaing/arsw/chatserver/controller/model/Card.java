package co.edu.escuelaing.arsw.chatserver.controller.model;

import co.edu.escuelaing.arsw.chatserver.controller.utils.CardStatus;
import co.edu.escuelaing.arsw.chatserver.controller.utils.MessageStatus;
import lombok.*;


// Lombok reduces the boilerplate code
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Card {
    private String id;
    private String content;
    private String limitDate;
    private CardStatus cardStatus;
    private String roomId;
}
