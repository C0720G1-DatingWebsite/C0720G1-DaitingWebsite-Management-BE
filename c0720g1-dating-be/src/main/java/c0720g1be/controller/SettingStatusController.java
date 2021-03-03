package c0720g1be.controller;

import c0720g1be.entity.Account;
import c0720g1be.service.IChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SettingStatusController {

    @Autowired
    private IChangePasswordService iChangePasswordService;

    @RequestMapping(value = "/setting-status/{id}/{statusId}", method = RequestMethod.PATCH)
    public ResponseEntity<Account> settingStatus(@PathVariable Integer id, @PathVariable Integer statusId) {
        if (iChangePasswordService.settingStatus(statusId, id)) {
            return new ResponseEntity<Account>(HttpStatus.OK);
        }
        return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
    }
}

