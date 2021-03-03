package c0720g1be.repository;

import c0720g1be.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PostWallAccountRepository extends JpaRepository<Post, Integer> {

    /**
     * Trung TQ: Lấy danh sách bài đăng theo id tài khoản
     * */
    @Query(value = "SELECT * FROM `post` where `post`.`account_id` = ?1  order by post_time desc", nativeQuery = true)
    Page<Post> findAllByIdPost(Integer id, Pageable pageable);


    @Query(value = "SELECT * FROM `post` where `post`.`account_id` = ?1  order by post_time desc limit ?2", nativeQuery = true)
    List<Post> findAllByIdPostList(Integer id, Integer size);

    /**
     * Trung TQ: lấy thông tin bài đăng theo id
     * */
    @Query(value = "SELECT * FROM `post` where `post`.`id` = ?1", nativeQuery = true)
    Post findByIdPost(Integer id);

}
