package c0720g1be.controller;

import c0720g1be.entity.AccountPost;
import c0720g1be.entity.Policy;
import c0720g1be.entity.Post;
import c0720g1be.service.AccountPostService;
import c0720g1be.service.AccountService;
import c0720g1be.service.PolicyService;
import c0720g1be.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * LuyenNT
 */
@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountPostService accountPostService;

    @Autowired
    private PolicyService policyService;

    @RequestMapping(value = "/accountPost",method = RequestMethod.GET)
    public ResponseEntity<List<AccountPost>> getAllAccountPost(){
        List<AccountPost> list = accountPostService.finAll();
        if (list.isEmpty()) {
            return new ResponseEntity<List<AccountPost>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/postGetAll/{idAccount}/size/{size}", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getAllPost(@PathVariable int idAccount,@PathVariable int size){
        List<Post> list = postService.getAllPost(idAccount,size);
        if (list.isEmpty()) {
            return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/postGetOneAccount/{idAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getOneAccountPost(@PathVariable int idAccount){
        List<Post> list = postService.findPostOneAccount(idAccount);
        if (list.isEmpty()) {
            return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/increaseLike/{idAccount}/oke/{idPost}", method = RequestMethod.PATCH)
    public ResponseEntity<?> increaseLike(@PathVariable int idAccount,@PathVariable int idPost){
        AccountPost accountPost = new AccountPost();
        accountPost.setAccount(accountService.findById(idAccount));
        accountPost.setPost(postService.findById(idPost));
        accountPostService.addAccountPost(accountPost);
        postService.increaseLike(idPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/reductionLike/{idPost}/oke/{idAccountPost}", method = RequestMethod.PATCH)
    public ResponseEntity<?> reductionLike(@PathVariable int idPost ,@PathVariable int idAccountPost){
        accountPostService.removeAccountPost(idAccountPost);
        postService.reductionLike(idPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/policyList",method = RequestMethod.GET)
    public ResponseEntity<List<Policy>> getAllPolicy(){
        return new ResponseEntity<List<Policy>>(policyService.findAllPolicy(),HttpStatus.OK);
    }
    @RequestMapping(value = "/editPost",method = RequestMethod.PUT)
    public ResponseEntity<?> editPost(@Valid @RequestBody Post post){
        Post postEdit = postService.findById(post.getId());
        postEdit.setImage(post.getImage());
        postEdit.setContent(post.getContent());
        postEdit.setPolicy(post.getPolicy());
        postService.editPost(postEdit);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
