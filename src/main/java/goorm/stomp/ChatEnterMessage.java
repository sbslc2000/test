package goorm.stomp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatEnterMessage {

    private String roomId;
    private String user;
}
