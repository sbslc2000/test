package goorm.stomp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ContainerWebSocketController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/terminal-input")
    public void enter(String data) {
        log.info("terminal-input: {}", data);
        template.convertAndSend("/topic/terminal-output", data);
    }
}
