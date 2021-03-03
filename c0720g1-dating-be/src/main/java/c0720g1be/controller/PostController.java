package c0720g1be.controller;

import c0720g1be.entity.Post;
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

    @RequestMapping(value = "/postGetAll/{idAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getAllPost(@PathVariable int idAccount){
        List<Post> list = postService.getAllPost(idAccount);
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

    @RequestMapping(value = "/increaseLike/{idAccount}", method = RequestMethod.GET)
    public ResponseEntity<?> increaseLike(@PathVariable int idAccount){
        postService.increaseLike(idAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/reductionLike/{idAccount}", method = RequestMethod.PATCH)
    public ResponseEntity<?> reductionLike(@PathVariable int idAccount){
        postService.reductionLike(idAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/editPost",method = RequestMethod.PUT)
    public ResponseEntity<?> editPost(@Valid @RequestBody Post post){
        Post postEdit = postService.findById(post.getId());
        postEdit.setContent(post.getContent());
        postEdit.setPolicy(post.getPolicy());
        postService.editPost(postEdit);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
