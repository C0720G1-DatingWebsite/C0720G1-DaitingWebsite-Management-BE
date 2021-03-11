package c0720g1be.controller;

import c0720g1be.dto.CommentDTO;
import c0720g1be.entity.Comment;
import c0720g1be.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/public/comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * Trung TQ: Lấy thêm mới comment
     * */

    @RequestMapping(value = "/create-comment", method = RequestMethod.POST)
    public ResponseEntity<Void> createCommentPost(@Valid @RequestBody CommentDTO commentDTO, UriComponentsBuilder ucBuilder) {
        commentService.createCommentPost(commentDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/findById/{id}").buildAndExpand(commentDTO.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Trung TQ: Lấy thêm mới reply
     * */

    @RequestMapping(value = "/create-reply", method = RequestMethod.POST)
    public ResponseEntity<Void> createReplyComment(@Valid @RequestBody CommentDTO commentDTO, UriComponentsBuilder ucBuilder) {
        commentService.createReplyComment(commentDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/findById/{id}").buildAndExpand(commentDTO.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Trung TQ: Cập nhập comment
     * */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Comment> updateComment(@PathVariable("id") Integer id, @RequestBody CommentDTO commentDTO) {
        Comment currentComment = commentService.findByIdComment(id);
        if (currentComment == null) {
            return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
        }
        commentService.updateComment(commentDTO);
        return new ResponseEntity<Comment>(currentComment, HttpStatus.OK);
    }

    /**
     * Trung TQ: Thông tin comment theo id
     * */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> findCommentById(@PathVariable("id") Integer id) {
        Comment comment = commentService.findByIdComment(id);
        if (comment == null) {
            return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }
    /**
     * Trung TQ: Danh sách comment
     * */
    @RequestMapping(value = "findById/{id}/page-comment", method = RequestMethod.GET)
    public ResponseEntity<Page<Comment>> listPostIdComment(@PathVariable("id") Integer id, @PageableDefault(size = 5) Pageable pageable) {
        Page<Comment> comments = commentService.findAllByComment(id, pageable);
        if (comments.isEmpty()) {
            return new ResponseEntity<Page<Comment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Comment>>(comments, HttpStatus.OK);
    }

    @RequestMapping(value = "findById/{id}/comment", method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity<Page<Comment>> pagePostIdComment(@RequestParam("page") int page,
                                                           @RequestParam("size") int size,
                                                           @PathVariable("id") Integer id) {
        Page<Comment> comments = commentService.findAllByComment(id, PageRequest.of(page, size));
        if (comments.isEmpty()) {
            return new ResponseEntity<Page<Comment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Comment>>(comments, HttpStatus.OK);
    }

    /**
     * Trung TQ: Danh sách reply
     * */
    @RequestMapping(value = "findById/{id}/page-reply", method = RequestMethod.GET)
    public ResponseEntity<Page<Comment>> listCommentIdReply(@PathVariable("id") Integer id, @PageableDefault(size = 20) Pageable pageable) {
        Page<Comment> comments = commentService.findAllByCommentReply(id, pageable);
        if (comments.isEmpty()) {
            return new ResponseEntity<Page<Comment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Comment>>(comments, HttpStatus.OK);
    }

    /**
     * Trung TQ: Danh sách reply - dùng để ẩn hiện
     * */
    @RequestMapping(value = "findById/{id}/reply", method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity<Page<Comment>> pageCommentIdReply(@RequestParam("page") int page,
                                                            @RequestParam("size") int size,
                                                            @PathVariable("id") Integer id) {
        Page<Comment> comments = commentService.findAllByCommentReply(id, PageRequest.of(page, size));
        if (comments.isEmpty()) {
            return new ResponseEntity<Page<Comment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Comment>>(comments, HttpStatus.OK);
    }

    /**
     * Trung TQ: Xóa một comment
     * */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Comment> deleteVaccination(@PathVariable("id") Integer id) {
        Comment comment = commentService.findByIdComment(id);
        if (comment == null) {
            return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
        }
        commentService.deleteComment(id);
        return new ResponseEntity<Comment>(HttpStatus.OK);
    }



}
