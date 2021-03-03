package c0720g1be.service.impl;

import c0720g1be.entity.Account;
import c0720g1be.repository.FriendListRepository;
import c0720g1be.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendListService implements IFriendListService {

    @Autowired
    private FriendListRepository friendListRepository;

    /**
     * get all list friend
     * create by LongBP
     */
    @Override
    public List<Account> getAllMadeFriends(Integer id) {
        return this.friendListRepository.getAllMadeFriends(id);
    }

    /**
     * get all list friend requests
     * create by LongBP
     */
    @Override
    public List<Account> getAllFriendRequest(Integer id) {
        return this.friendListRepository.getALlFriendRequest(id);
    }

    /**
     * accept friends request
     * create by LongBP
     */
    @Override
    public void acceptNewFriend(Integer accountId, Integer friendId) {
        this.friendListRepository.acceptNewFriend(accountId, friendId);
    }

    /**
     * del friends request
     * create by LongBP
     */
    @Override
    public void delNewFriend(Integer accountId, Integer friendId) {
        this.friendListRepository.delNewFriend(accountId, friendId);
    }

    /**
     * get friend by id
     * create by LongBP
     */
    @Override
    public Account getFriendById(Integer id) {
        return this.friendListRepository.getFriendById(id);
    }

}
