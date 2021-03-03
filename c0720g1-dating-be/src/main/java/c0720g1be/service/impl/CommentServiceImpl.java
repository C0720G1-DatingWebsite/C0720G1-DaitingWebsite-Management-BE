package c0720g1be.service.impl;

import c0720g1be.dto.CommentDTO;
import c0720g1be.entity.Comment;
import c0720g1be.repository.CommentRepository;
import c0720g1be.repository.PostWallAccountRepository;
import c0720g1be.service.AccountService;
import c0720g1be.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {

    /**
     * Trung TQ: CRUD comment theo thời gian thực
     * */
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostWallAccountRepository postWallAccountRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public Comment findByIdComment(Integer id) {
        return commentRepository.findByIdComment(id);
    }

    @Override
    public void createCommentPost(CommentDTO commentDTO) {
        commentRepository.createCommentPost(commentDTO.getContent(), LocalDateTime.now().toString(), commentDTO.getAccountId(), false, commentDTO.getPostId());
    }

    @Override
    public void createReplyComment(CommentDTO commentDTO) {
        commentRepository.createReplyComment(commentDTO.getContent(), LocalDateTime.now().toString(), commentDTO.getAccountId(), false,commentDTO.getCommentId());
    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        commentRepository.updateComment(commentDTO.getContent(), commentDTO.getId());
    }

    @Override
    public Page<Comment> findAllByComment(Integer id, Pageable pageable) {
        return commentRepository.findAllByComment(id, pageable);
    }

    @Override
    public Page<Comment> findAllByCommentReply(Integer id, Pageable pageable) {
        return commentRepository.findAllByCommentReply(id, pageable);
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteComment(true, id);
    }
}
