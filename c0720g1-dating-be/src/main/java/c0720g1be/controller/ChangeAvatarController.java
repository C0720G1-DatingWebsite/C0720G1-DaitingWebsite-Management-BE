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
    @RequestMapping(value = "/change-avatar", method = RequestMethod.PATCH)
    @ResponseBody
    public boolean changeAvatar(@RequestParam Integer idAccount, @RequestParam(defaultValue = "") String avatar){
        return iChangePasswordService.changeAvatar(avatar, idAccount);
    }
}
