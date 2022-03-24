package co.edu.escuelaing.arsw.chatserver.controller.model;

import co.edu.escuelaing.arsw.chatserver.controller.Status;
import lombok.*;


// Lombok reduces the boilerplate code
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;


}
