package c0720g1be.service;

import c0720g1be.dto.ChatDTO;
import c0720g1be.entity.Chat;

import java.util.List;

public interface MessageService {
    void addMessage(String sender,String content,String timeStamp, Integer boxId,String imgUrl);
    List<Chat> listMessage(Integer boxId);
}
