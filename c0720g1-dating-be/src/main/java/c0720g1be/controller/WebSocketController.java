package c0720g1be.controller;

import c0720g1be.dto.ChatDTO;
import c0720g1be.entity.Chat;
import c0720g1be.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebSocketController {
    @Autowired
    private MessageService messageService;
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/1234")
    public ChatDTO sendMessage(@Payload ChatDTO chat) {
        if(chat.getContent()!=null) {
            messageService.addMessage(chat.getSender(), chat.getContent(), chat.getTimeStamp(), chat.getBoxId(),chat.getImgUrl());
        }
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
