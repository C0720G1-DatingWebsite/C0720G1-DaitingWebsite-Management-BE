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
    @Query(value = "select account.* from friend join account on account.id = friend.friend_id where friend.account_id = ?1 and friend.state_id = 1", nativeQuery = true)
    List<Account> getAllMadeFriends(Integer id);

    /**
     * get all list friend requests
     * create by LongBP
     */
    @Query(value = "select account.* from friend join account on account.id = friend.friend_id where friend.account_id = ?1 and friend.state_id = 2", nativeQuery = true)
    List<Account> getALlFriendRequest(Integer id);

//    /**
//     * add friends
//     * create by LongBP
//     */
//    @Transactional
//    @Modifying
//    @Query(value = "insert into friend(account_id,friend_id,state_id) values (?1,?2,2)", nativeQuery = true)
//    void addNewFriend(Integer accountId, Integer friendId);


    /**
     * accept friends request
     * create by LongBP
     */
    @Transactional
    @Modifying
    @Query(value = "update friend set friend.state_id = 1 where friend.friend_id = ?2 and friend.account_id = ?1", nativeQuery = true)
    void acceptNewFriend(Integer accountId, Integer friendId);


    /**
     * del friends request
     * create by LongBP
     */
    @Transactional
    @Modifying
    @Query(value = "update friend set friend.state_id = 3 where friend.friend_id = ?2 and friend.account_id = ?1", nativeQuery = true)
    void delNewFriend(Integer accountId, Integer friendId);


    /**
     * get account by id
     * create by LongBP
     */
    @Query(value = "select * from account where id = ?1 ", nativeQuery = true)
    Account getFriendById(Integer id);

}
