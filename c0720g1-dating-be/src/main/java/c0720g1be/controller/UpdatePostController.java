package c0720g1be.controller;


import c0720g1be.dto.IPolicyDTO;
import c0720g1be.entity.Policy;
import c0720g1be.entity.Post;
import c0720g1be.service.ICreatePostService;
import c0720g1be.service.IPolicyService;
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
    IPolicyService iPolicyService;

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
     * Võ Thành Tín: Get All Policy
     */
    @RequestMapping(value = "/get-list-policy", method = RequestMethod.GET)
    public ResponseEntity<List<IPolicyDTO>> getAllPolicy(){
        List<IPolicyDTO> listPolicy = iPolicyService.getAllPolicy();
        if(listPolicy.isEmpty()){
            return new ResponseEntity<List<IPolicyDTO>>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<List<IPolicyDTO>>(listPolicy,HttpStatus.OK);
        }
    }
}

