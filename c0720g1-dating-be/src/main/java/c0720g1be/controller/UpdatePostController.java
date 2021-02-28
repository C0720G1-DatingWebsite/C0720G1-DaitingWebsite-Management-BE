package c0720g1be.controller;


import c0720g1be.entity.Post;
import c0720g1be.entity.Status;
import c0720g1be.service.ICreatePostService;
import c0720g1be.service.IStatusUpdatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UpdatePostController {
    @Autowired
    ICreatePostService iCreatePostService;

    @Autowired
    IStatusUpdatePostService iStatusUpdatePostService;

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


    /**
     * Võ Thành Tín: Get All Status
     */
    @RequestMapping(value = "/get-list-status", method = RequestMethod.GET)
    public ResponseEntity<List<Status>> getAllStatus(){
        List<Status> listStatus = iStatusUpdatePostService.getAllStatus();
        if(listStatus.isEmpty()){
            return new ResponseEntity<List<Status>>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<List<Status>>(listStatus,HttpStatus.OK);
        }
    }
}

