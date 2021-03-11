package c0720g1be.controller;


import c0720g1be.dto.CreatePostDTO;
import c0720g1be.dto.IPolicyDTO;
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
     * @return
     */
    @RequestMapping(value = "/create-post", method = RequestMethod.POST)
    @ResponseBody
    public boolean createPost(@RequestBody CreatePostDTO postDTO) {
        if (postDTO != null) {
            if (iCreatePostService.createPost(postDTO.getContentPost(), postDTO.getIdAccount(), postDTO.getIdPolicy(), postDTO.getImagePost())) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/create-post-group", method = RequestMethod.POST)
    @ResponseBody
    public boolean createPostGroup(@RequestBody CreatePostDTO postDTO) {
        if (postDTO != null) {
            if (iCreatePostService.createPostGroup(postDTO)) {
                return true;
            }
        }
        return false;
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

