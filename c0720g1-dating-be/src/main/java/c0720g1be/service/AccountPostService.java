package c0720g1be.service;

import c0720g1be.entity.AccountPost;

import java.util.List;

public interface AccountPostService {

    List<AccountPost> finAll();
    void addAccountPost(AccountPost accountPost);
    void removeAccountPost(Integer id);
}
