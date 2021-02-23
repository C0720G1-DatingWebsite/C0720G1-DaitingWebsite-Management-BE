package c0720g1be.controller;

import c0720g1be.entity.Account;
import c0720g1be.service.WallAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/wall-account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WallAccountController {
    @Autowired
    WallAccountService wallAccountService;

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> findAccountDatingById(@PathVariable("id") Integer id) {
        Account account = wallAccountService.findByIdAccount(id);
        if (account == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
}
