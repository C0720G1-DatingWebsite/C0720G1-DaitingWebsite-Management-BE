package c0720g1be.service.impl;

import c0720g1be.dto.CommentDTO;
import c0720g1be.entity.Comment;
import c0720g1be.entity.Post;
import c0720g1be.repository.AccountRepository;
import c0720g1be.repository.CommentRepository;
import c0720g1be.repository.PostWallAccountRepository;
import c0720g1be.service.AccountService;
import c0720g1be.service.CommentService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Optional;

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
        commentRepository.createReplyComment(commentDTO.getContent(), LocalDateTime.now().toString(), commentDTO.getAccountId(), commentDTO.getCommentId(), commentDTO.getPostId());
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
}
