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
    void acceptNewFriend(Integer accountId, Integer friendId);

    /**
     * del friends request
     * create by LongBP
     */
    void delNewFriend(Integer accountId, Integer friendId);

    /**
     * get friend by id
     * create by LongBP
     */
    Account getFriendById(Integer id);
}
