package c0720g1be.repository;

import c0720g1be.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    /**
     * Trung TQ: Lấy danh sách bạn bè
     * */
    @Query(value = "select * from friend where account_id = ?", nativeQuery = true)
    List<Friend> findAllByFriend(Integer id);

    @Query(value = "select * from friend", nativeQuery = true)
    List<Friend> findAllByFriend();

}
