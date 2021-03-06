package c0720g1be.repository;

import c0720g1be.dto.FriendDTO;
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
    @Query(value = "select account.background_image as backgroundImage, account.avatar as avatar, account.user_name as username, \n" +
            " account.full_name as fullName, account.account_describe as describeAcc,friend.state_id as state ,account.id as accountID, friend.friend_id as friendID, \n" +
            " (select count(account.id) \n" +
            " from account \n" +
            " where account.id in ( select friend.friend_id from friend where friend.account_id = accountID) \n" +
            " and account.id in ( select friend.friend_id from friend where friend.account_id = ?1) ) as mutualFriends \n" +
            " from account \n" +
            " join friend on account.id = friend.account_id \n" +
            " where account.id != ?1 and friend.friend_id = ?1 and friend.state_id =1;", nativeQuery = true)
    List<FriendDTO> getAllMadeFriends(Integer id);

    /**
     * get all list friend requests
     * create by LongBP
     */
    @Query(value = "select account.background_image as backgroundImage, account.avatar as avatar, account.user_name as username, \n" +
            " account.full_name as fullName, account.account_describe as describeAcc,friend.state_id as state ,account.id as friendID, friend.friend_id as accountID, \n" +
            " (select count(account.id) \n" +
            " from account \n" +
            " where account.id in ( select friend.friend_id from friend where friend.account_id = friendID) \n" +
            " and account.id in ( select friend.friend_id from friend where friend.account_id = ?1) ) as mutualFriends \n" +
            " from account\n" +
            " join friend on account.id = friend.account_id \n" +
            " where friend.account_id != ?1 and friend.friend_id = ?1 and friend.state_id = 2", nativeQuery = true)
    List<FriendDTO> getALlFriendRequest(Integer id);

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
    @Query(value = "update friend set friend.state_id = 1 where friend.account_id = ?1 and friend.friend_id = ?2", nativeQuery = true)
    void acceptNewFriend(Integer accountID, Integer friendID);

    @Transactional
    @Modifying
    @Query(value = "update friend set friend.state_id = 1 where friend.account_id = ?2 and friend.friend_id = ?1", nativeQuery = true)
    void acceptNewFriend2(Integer accountID, Integer friendID);

    /**
     * del friends request
     * create by LongBP
     */
    @Transactional
    @Modifying
    @Query(value = "delete from friend where friend.account_id = ?1 and friend.friend_id = ?2", nativeQuery = true)
    void delNewFriend(Integer friendID, Integer accountID);

    @Transactional
    @Modifying
    @Query(value = "delete from friend where friend.account_id = ?2 and friend.friend_id = ?1", nativeQuery = true)
    void delNewFriend2(Integer friendID, Integer accountID);


    /**
     * get account by id
     * create by LongBP
     */
    @Query(value = "select account.id as accountID, account.background_image as backgroundImage, account.avatar as avatar, account.user_name as username, \n" +
            " account.full_name as fullName, account.account_describe as accountDescribe \n" +
            " from account \n" +
            " where account.id = ?1", nativeQuery = true)
    FriendDTO getFriendById(Integer id);

    /**
     * search list friend by name
     * create by LongBP
     */
    @Query(value = "select account.background_image as backgroundImage, account.avatar as avatar, account.user_name as username, \n" +
            " account.full_name as fullName, account.account_describe as describeAcc,friend.state_id as state ,account.id as accountID, friend.friend_id as friendID, \n" +
            " (select count(account.id) \n" +
            " from account \n" +
            " where account.id in ( select friend.friend_id from friend where friend.account_id = accountID) \n" +
            " and account.id in ( select friend.friend_id from friend where friend.account_id = ?1) ) as mutualFriends \n" +
            " from account \n" +
            " join friend on account.id = friend.account_id \n" +
            " where account.id != ?1 and friend.friend_id = ?1 and account.full_name like ?2 and friend.state_id =1", nativeQuery = true)
    List<FriendDTO> searchFriends(Integer id, String name);

    /**
     * search add friend by name
     * create by LongBP
     */
    @Query(value = "select account.background_image as backgroundImage, account.avatar as avatar, account.user_name as username, \n" +
            " account.full_name as fullName, account.account_describe as accountDescribe,friend.state_id as stateID ,account.id as accountID, friend.friend_id as friendID, \n" +
            " (select count(account.id) \n" +
            " from account \n" +
            " where account.id in ( select friend.friend_id from friend where friend.account_id = accountID) \n" +
            " and account.id in ( select friend.friend_id from friend where friend.account_id = ?1) ) as mutualFriends \n" +
            " from account \n" +
            " left join friend on account.id = friend.friend_id \n" +
            " where account.full_name like ?2 and account.id != ?1", nativeQuery = true)
    List<FriendDTO> searchAddFriends(Integer id, String name);
}
