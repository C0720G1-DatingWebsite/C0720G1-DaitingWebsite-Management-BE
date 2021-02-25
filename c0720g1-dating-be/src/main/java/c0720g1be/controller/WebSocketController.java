package c0720g1be.controller;

import c0720g1be.dto.ChatDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/1234")
    public ChatDTO sendMessage(@Payload ChatDTO chat) {
        return chat;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/1234")
    public ChatDTO addUser(@Payload ChatDTO chat, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chat.getSender());
        return chat;
    }

}
