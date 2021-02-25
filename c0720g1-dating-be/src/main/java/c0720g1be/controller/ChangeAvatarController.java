package c0720g1be.controller;

import c0720g1be.entity.Account;
import c0720g1be.service.IChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ChangeAvatarController {

    @Autowired
    private IChangePasswordService iChangePasswordService;

    /**
     * Võ Thành Tín: Change Avatar
     */
    @RequestMapping(value = "/change-avatar/{id}/{avatar}", method = RequestMethod.PATCH)
    public ResponseEntity<Account> changeAvatar(@PathVariable Integer id, @PathVariable String avatar){
        if(iChangePasswordService.changeAvatar(avatar, id)){
            return new ResponseEntity<Account>(HttpStatus.OK);
        }return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
    }
}
