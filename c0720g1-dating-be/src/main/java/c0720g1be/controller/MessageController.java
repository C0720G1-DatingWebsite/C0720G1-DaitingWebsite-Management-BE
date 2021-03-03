package c0720g1be.controller;

import c0720g1be.dto.ChatDTO;
import c0720g1be.entity.Chat;
import c0720g1be.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "list-message/{boxId}/{limit}", method = RequestMethod.GET)
    public  ResponseEntity<?> getListMessage(@PathVariable("boxId") int boxId, @PathVariable int limit) {
        Stack<Chat> stack = new Stack<>();
        List<Chat> list = this.messageService.listMessage(boxId,limit);
        for (Chat a:list) {
          stack.push(a);
        }
        List<Chat> list2 = new ArrayList<>();
        while(!stack.isEmpty()) {
             list2.add(stack.pop());
        }
        return new ResponseEntity<>( list2,HttpStatus.OK);
    }
    @RequestMapping(value = "delete-message/{boxId}", method = RequestMethod.GET)
    public  ResponseEntity<?> deleteAllMessage(@PathVariable("boxId") int boxId) {
        this.messageService.deleteMessage(boxId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
