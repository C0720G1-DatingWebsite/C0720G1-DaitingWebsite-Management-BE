package c0720g1be.repository;

import c0720g1be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FriendListRepository extends JpaRepository<Account,Integer> {
    /**
     * get all list friend
     * create by LongBP
     */
    @Query(value = "select account.* from friend join account on account.id = friend.account_id where friend.friend_id = ?1 and friend.state_id = 1", nativeQuery = true)
    List<Account> getAllMadeFriends(Integer id);

    /**
     * get all list friend requests
     * create by LongBP
     */
    @Query(value = "select account.* from friend join account on account.id = friend.account_id where friend.friend_id = ?1 and friend.state_id = 2", nativeQuery = true)
    List<Account> getALlFriendRequest(Integer id);

    /**
     * add friends
     * create by LongBP
     */
    @Transactional
    @Modifying
    @Query(value = "insert into friend(account_id,friend_id,state_id) values (?1,?2,2)", nativeQuery = true)
    void addNewFriend(Integer accountId, Integer friendId);

    @Transactional
    @Modifying
    @Query(value = "insert into friend(account_id,friend_id,state_id) values (?2,?1,3)", nativeQuery = true)
    void addNewFriend2(Integer accountId, Integer friendId);

    /**
     * accept friends request
     * create by LongBP
     */
    @Transactional
    @Modifying
    @Query(value = "update friend set friend.state_id = 1 where friend.friend_id = ?1 and friend.account_id = ?2", nativeQuery = true)
    void acceptNewFriend(Integer friendId, Integer accountId);

    @Transactional
    @Modifying
    @Query(value = "update friend set friend.state_id = 1 where friend.friend_id = ?2 and friend.account_id = ?1", nativeQuery = true)
    void acceptNewFriend2(Integer friendId, Integer accountId);

    /**
     * del friends request
     * create by LongBP
     */
    @Transactional
    @Modifying
    @Query(value = "delete from friend where friend.account_id = ?1 and friend.friend_id = ?2", nativeQuery = true)
    void delNewFriend(Integer accountId, Integer friendId );

    @Transactional
    @Modifying
    @Query(value = "delete from friend where friend.account_id = ?2 and friend.friend_id = ?1", nativeQuery = true)
    void delNewFriend2(Integer accountId, Integer friendId );


    /**
     * get account by id
     * create by LongBP
     */
    @Query(value = "select * from account where id = ?1 ", nativeQuery = true)
    Account getFriendById(Integer id);

    /**
     * search list friend by name
     * create by LongBP
     */
    @Query(value = "select account.* from friend join account on account.id = friend.friend_id where friend.account_id = ?1 and friend.state_id = 1 and account.full_name like ?2", nativeQuery = true)
    List<Account> searchFriends(Integer id,String name);

    /**
     * search add friend by name
     * create by LongBP
     */
    @Query(value = "select account.* from account where account.full_name like ?2 and account.id != ?1 ", nativeQuery = true)
    List<Account> searchAddFriends(Integer id, String name);
}
