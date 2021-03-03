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
    public void acceptNewFriend(Integer friendId, Integer accountId) {
        this.friendListRepository.acceptNewFriend(friendId, accountId);
    }

    @Override
    public void acceptNewFriend2(Integer friendId, Integer accountId) {
        this.friendListRepository.acceptNewFriend2(friendId, accountId);
    }

    /**
     * del friends request
     * create by LongBP
     */
    @Override
    public void delNewFriend(Integer accountId,Integer friendId) {
        this.friendListRepository.delNewFriend(accountId,friendId);
    }

    @Override
    public void delNewFriend2(Integer accountId, Integer friendId) {
        this.friendListRepository.delNewFriend2(accountId, friendId);
    }

    /**
     * get friend by id
     * create by LongBP
     */
    @Override
    public Account getFriendById(Integer id) {
        return this.friendListRepository.getFriendById(id);
    }

    /**
     * search list friend by name
     * create by LongBP
     */
    @Override
    public List<Account> searchFriends(Integer id, String name) {
        return this.friendListRepository.searchFriends(id, name);
    }

    /**
     * search add friend by name
     * create by LongBP
     */
    @Override
    public List<Account> searchAddFriends(Integer id, String nameFriends) {
        return this.friendListRepository.searchAddFriends(id,nameFriends);
    }

    /**
     * add friends
     * create by LongBP
     */
    @Override
    public void addNewFriend(Integer accountId, Integer friendId) {
        this.friendListRepository.addNewFriend(accountId, friendId);
    }

    @Override
    public void addNewFriend2(Integer accountId, Integer friendId) {
        this.friendListRepository.addNewFriend2(accountId, friendId);
    }

}
