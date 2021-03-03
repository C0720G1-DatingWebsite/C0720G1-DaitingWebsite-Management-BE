package c0720g1be.controller;

import c0720g1be.entity.Chat;
import c0720g1be.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping(value = "list-message/{boxId}", method = RequestMethod.GET)
    public  ResponseEntity<?> deleteGroup(@PathVariable("boxId") int boxId) {
        return new ResponseEntity<>( this.messageService.listMessage(boxId),HttpStatus.OK);
    }

}
