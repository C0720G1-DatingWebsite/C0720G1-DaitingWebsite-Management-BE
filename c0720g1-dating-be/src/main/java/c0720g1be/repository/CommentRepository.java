package c0720g1be.repository;

import c0720g1be.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    /**
     * Trung TQ: CRUD Comment
     * */
    @Query(value = "SELECT * FROM `comment` where `comment`.`id` = ?1", nativeQuery = true)
    Comment findByIdComment(Integer id);

    @Query(value = "SELECT * FROM comment where comment.post_id =?1 and delete_flag = false order by date_comment DESC", nativeQuery = true)
    Page<Comment> findAllByComment(Integer id, Pageable pageable);


    @Query(value = "SELECT * FROM comment where comment.comment_id = ?1 order by date_comment DESC", nativeQuery = true)
    Page<Comment> findAllByCommentReply(Integer idReply, Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO `comment`(`content`,`date_comment` ,`account_id`, `comment_id`, `post_id`) " +
            "value (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void createReplyComment(String content, String dateComment, Integer accountId, Integer commentId, Integer postId);

    @Modifying
    @Query(value = "INSERT INTO `comment`(`content`,`date_comment` ,`account_id`, `delete_flag` ,`post_id`) " +
            "value (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void createCommentPost(String content, String dateComment, Integer accountId, Boolean deleteFlag,Integer postId);

    @Modifying
    @Query(value = "UPDATE `comment` SET `content` = ?1 WHERE (`id` = ?2)", nativeQuery = true )
    void updateComment(String content, Integer id);
}
