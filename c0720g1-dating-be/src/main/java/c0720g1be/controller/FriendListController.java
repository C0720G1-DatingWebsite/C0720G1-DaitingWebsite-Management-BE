package c0720g1be.controller;

import c0720g1be.entity.Account;
import c0720g1be.service.impl.FriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/public")
public class FriendListController {
    @Autowired
    private FriendListService friendListService;

    /**
     * get account by id
     * create by LongBP
     */
    @GetMapping("/profile/{id}")
    public ResponseEntity<Account> getFriendById(@PathVariable Integer id){
        Account account = this.friendListService.getFriendById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    /**
     * get all list friend
     * create by LongBP
     */
    @GetMapping("/profile/{id}/friend-list")
    public ResponseEntity<List<Account>> getAllFriendList(@PathVariable Integer id){
        List<Account> account = this.friendListService.getAllMadeFriends(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    /**
     * get all list friend requests
     * create by LongBP
     */
    @GetMapping("/profile/{id}/friend-request")
    public ResponseEntity<List<Account>> getAllFriendRequest(@PathVariable Integer id){
        List<Account> accounts = this.friendListService.getAllFriendRequest(id);
        if (accounts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    /**
     * accept friends request
     * create by LongBP
     */

    @GetMapping("/accept-friend-request")
    public ResponseEntity<?> acceptNewFriend(@RequestParam Integer idFriend,
                                             @RequestParam Integer idAccount) {
        Account accounts = friendListService.getFriendById(idAccount);
        if (accounts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.friendListService.acceptNewFriend(idAccount, idFriend);
        this.friendListService.acceptNewFriend2(idAccount, idFriend);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * del friends request
     * create by LongBP
     */

    @GetMapping("/del-friend-request")
    public ResponseEntity<?> delNewFriend(@RequestParam Integer idAccount,
                                          @RequestParam Integer idFriend) {
        Account accounts = friendListService.getFriendById(idAccount);
        if (accounts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.friendListService.delNewFriend(idFriend,idAccount);
        this.friendListService.delNewFriend2(idFriend,idAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * search list friend by name
     * create by LongBP
     */
    @GetMapping(value = "/profile/{id}/friend-list/search")
    public ResponseEntity<List<Account>> searchFriends(@PathVariable Integer id,
                                                       @RequestParam String name){
        List<Account> accounts;
        if (name.equals("")) {
            accounts = friendListService.getAllMadeFriends(id);
        }
        else {
            accounts = friendListService.searchFriends(id, "%" + name + "%");
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    /**
     * search add friend by name
     * create by LongBP
     */
    @GetMapping(value = "/profile/{id}/search")
    public ResponseEntity<List<Account>> searchAddFriends(@PathVariable Integer id,
                                                          @RequestParam String nameFriends){
        List<Account> accounts = friendListService.searchAddFriends(id,"%" + nameFriends + "%");
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    /**
     * add friends
     * create by LongBP
     */

    @GetMapping("/add-friend")
    public ResponseEntity<?> addNewFriend(@RequestParam Integer idAccount,
                                          @RequestParam Integer idFriend) {
        Account accounts = friendListService.getFriendById(idAccount);
        if (accounts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.friendListService.addNewFriend(idAccount, idFriend);
        this.friendListService.addNewFriend2(idAccount, idFriend);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
