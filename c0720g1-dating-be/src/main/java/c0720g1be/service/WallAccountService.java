package c0720g1be.service;

import c0720g1be.entity.Account;
import c0720g1be.entity.AccountGroup;
import c0720g1be.entity.Friend;
import c0720g1be.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface WallAccountService {
    Account findByIdAccount(Integer id);

    Page<Post> findAllByIdPost(Integer id, Pageable pageable);

    List<Post> findAllByIdPost(Integer id);

    Post findByIdPost(Integer id);

    List<AccountGroup> findAllByIdAccountGroup(Integer id);

    List<Friend> findAllByIdAccountFriend(Integer id);
    List<Friend> findAllByFriend();
}
