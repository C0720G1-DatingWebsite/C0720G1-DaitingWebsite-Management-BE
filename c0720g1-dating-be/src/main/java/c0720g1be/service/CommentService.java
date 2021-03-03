package c0720g1be.service;

import c0720g1be.dto.CommentDTO;
import c0720g1be.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Comment findByIdComment(Integer id);

    void createCommentPost (CommentDTO commentDTO);

    void createReplyComment(CommentDTO commentDTO);

    void updateComment(CommentDTO commentDTO);

    Page<Comment> findAllByComment(Integer id, Pageable pageable);

    Page<Comment> findAllByCommentReply(Integer id, Pageable pageable);

    void deleteComment(Integer id);


}
