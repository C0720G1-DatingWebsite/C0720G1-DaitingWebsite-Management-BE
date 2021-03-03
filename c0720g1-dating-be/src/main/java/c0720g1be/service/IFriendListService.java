package c0720g1be.service;

import c0720g1be.entity.Account;

import java.util.List;

public interface IFriendListService {
    /**
     * get all list friend
     * create by LongBP
     */
    List<Account> getAllMadeFriends(Integer id);

    /**
     * get all list friend requests
     * create by LongBP
     */
    List<Account> getAllFriendRequest(Integer id);

    /**
     * accept friends request
     * create by LongBP
     */
    void acceptNewFriend(Integer friendId, Integer accountId);
    void acceptNewFriend2(Integer friendId, Integer accountId);

    /**
     * del friends request
     * create by LongBP
     */
    void delNewFriend(Integer accountId,Integer friendId);
    void delNewFriend2(Integer accountId,Integer friendId);

    /**
     * get friend by id
     * create by LongBP
     */
    Account getFriendById(Integer id);

    /**
     * search list friend by name
     * create by LongBP
     */
    List<Account> searchFriends(Integer id,String name);

    /**
     * search add friend by name
     * create by LongBP
     */
    List<Account> searchAddFriends(Integer id, String nameFriends);

    /**
     * add friends
     * create by LongBP
     */
    void addNewFriend(Integer accountId, Integer friendId);
    void addNewFriend2(Integer accountId, Integer friendId);
}
