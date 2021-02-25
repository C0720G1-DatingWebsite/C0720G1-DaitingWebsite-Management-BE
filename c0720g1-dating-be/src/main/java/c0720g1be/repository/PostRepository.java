package c0720g1be.repository;

import c0720g1be.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/** LuyenNT
 */
@Transactional
public interface PostRepository extends JpaRepository<Post,Integer> {
    @Modifying
    @Query(value = "UPDATE Post set post.like_count = post.like_count + 1 where id = ?", nativeQuery = true)
    void increaseLike(int id);

    @Modifying
    @Query(value = "UPDATE Post set post.like_count = post.like_count - 1 where id = ?", nativeQuery = true)
    void reductionLike(int id);

    @Query(value = "select * from post " +
            "where post.account_id = ?", nativeQuery = true)
    List<Post> findByAccount(int idAccount);

    @Query(value = "select * from post " +
            "join friend on post.account_id = friend.friend_id " +
            "where friend.account_id = ? ORDER BY post.post_time DESC ",nativeQuery = true)
    List<Post> findAllPost(Integer idAccount);

    @Query(value = "select * from Post where id = ?", nativeQuery = true)
    Post getByIdPost(Integer id);
}
