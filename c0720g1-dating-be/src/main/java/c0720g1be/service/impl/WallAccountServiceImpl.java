package c0720g1be.service.impl;

import c0720g1be.dto.AccountWallDTO;
import c0720g1be.entity.Account;
import c0720g1be.entity.AccountGroup;
import c0720g1be.entity.Friend;
import c0720g1be.entity.Post;
import c0720g1be.repository.*;
import c0720g1be.service.WallAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WallAccountServiceImpl implements WallAccountService {
    @Autowired
    WallAccountRepository wallAccountRepository;
    @Autowired
    PostWallAccountRepository postWallAccountRepository;
    @Autowired
    AccountGroupRepository accountGroupRepository;
    @Autowired
    FriendRepository friendRepository;

    /**
     * Trung TQ: Lấy Danh sách bạn bè, bài post, nhóm theo id tài khoản
     * */

    @Override
    public Account findByIdAccount(Integer id) {
        return wallAccountRepository.findByIdAccount(id);
    }

    @Override
    public Page<Post> findAllByIdPost(Integer id, Pageable pageable) {
        return postWallAccountRepository.findAllByIdPost(id, pageable);
    }

    @Override
    public List<Post> findAllByIdPost(Integer id) {
        return postWallAccountRepository.findAllByIdPostList(id);
    }

    @Override
    public Post findByIdPost(Integer id) {
        return postWallAccountRepository.findByIdPost(id);
    }

    @Override
    public List<AccountGroup> findAllByIdAccountGroup(Integer id) {
        return accountGroupRepository.findAllByIdAccount(id);
    }

    @Override
    public List<Friend> findAllByIdAccountFriend(Integer id) {
        return friendRepository.findAllByFriend(id);
    }

    @Override
    public List<Friend> findAllByFriend() {
        return friendRepository.findAllByFriend();
    }


}
