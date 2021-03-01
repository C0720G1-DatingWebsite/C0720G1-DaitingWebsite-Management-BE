package c0720g1be.service.impl;

import c0720g1be.dto.ChatDTO;
import c0720g1be.entity.Chat;
import c0720g1be.repository.MessageRepository;
import c0720g1be.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
@Autowired
private MessageRepository messageRepository;

    @Override
    public void addMessage(String sender, String content, String timeStamp, Integer boxId, String imgUrl) {
        messageRepository.addMessage(sender,content,timeStamp,boxId,imgUrl);
    }

    @Override
    public List<Chat> listMessage(Integer boxId) {
        return messageRepository.listMessage(boxId);
    }
}
