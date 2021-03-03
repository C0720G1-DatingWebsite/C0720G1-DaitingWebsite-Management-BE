package c0720g1be.repository;

import c0720g1be.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CreatePostRepository extends JpaRepository<Post,Integer> {


    /**
     * Võ Thành Tín: Create New Post
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "insert into post(post.content, post.post_time, post.account_id, post.policy_id, post.image_post, post.like_count) " +
            "value (?1,?2,?3,?4,?5,0)",nativeQuery = true)
    void createPost(String content, String postTime, Integer accountId, Integer policyId, String image);
}

