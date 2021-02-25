package c0720g1be.controller;


import c0720g1be.entity.Post;
import c0720g1be.service.ICreatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CreatePostController {
    @Autowired
    ICreatePostService iCreatePostService;


    /**
     * Võ Thành Tín: Create New Post
     */
    @RequestMapping(value = "/create-post", method = RequestMethod.POST)
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        if (post == null) {
            return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
        } else if (iCreatePostService.createPost(post)) {
            return new ResponseEntity<Post>(HttpStatus.OK);
        }
        return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
    }
}

