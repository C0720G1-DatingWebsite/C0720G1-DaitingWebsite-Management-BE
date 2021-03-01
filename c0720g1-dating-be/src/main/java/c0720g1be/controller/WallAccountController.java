package c0720g1be.controller;

import c0720g1be.entity.Account;
import c0720g1be.entity.AccountGroup;
import c0720g1be.entity.Friend;
import c0720g1be.entity.Post;
import c0720g1be.service.WallAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/wall-account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WallAccountController {
    @Autowired
    WallAccountService wallAccountService;

    /**
     * Trung TQ: Lấy thông tin tài khoản
     * */

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> findAccountDatingById(@PathVariable("id") Integer id) {
        Account account = wallAccountService.findByIdAccount(id);
        if (account == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
    /**
     * Trung TQ: Lấy danh sách bải đăng theo id tài khoản
     * */

    @RequestMapping(value = "/findById/{id}/list-post", method = RequestMethod.GET)
    public ResponseEntity<Page<Post>> pagePost(@PathVariable("id") Integer accountId, @PageableDefault(size = 5) Pageable pageable) {
        Page<Post> postPage = wallAccountService.findAllByIdPost(accountId, pageable);
        if (postPage.isEmpty()) {
            return new ResponseEntity<Page<Post>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Post>>(postPage, HttpStatus.OK);
    }

    @RequestMapping(value = "/findByIdPost/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> findPostById(@PathVariable("id") Integer id) {
        Post post = wallAccountService.findByIdPost(id);
        if (post == null) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }


    /**
     * Trung TQ: Lấy danh sách nhóm theo id tài khoản
     * */
    @RequestMapping(value = "/findById/{id}/list-group", method = RequestMethod.GET)
    public ResponseEntity<List<AccountGroup>> listGroup(@PathVariable("id") Integer id) {
        List<AccountGroup> listGroup = wallAccountService.findAllByIdAccountGroup(id);
        if (listGroup.isEmpty()) {
            return new ResponseEntity<List<AccountGroup>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AccountGroup>>(listGroup, HttpStatus.OK);
    }

    /**
     * Trung TQ: Lấy danh sách bạn bè theo id tài khoản
     * */
    @RequestMapping(value = "/findById/{id}/list-friend", method = RequestMethod.GET)
    public ResponseEntity<List<Friend>> listFriend(@PathVariable("id") Integer id) {
        List<Friend> friendList = wallAccountService.findAllByIdAccountFriend(id);
        if (friendList.isEmpty()) {
            return new ResponseEntity<List<Friend>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Friend>>(friendList, HttpStatus.OK);
    }

}
