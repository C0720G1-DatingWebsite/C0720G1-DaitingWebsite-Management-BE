package c0720g1be.service.impl;

import c0720g1be.entity.AccountPost;
import c0720g1be.repository.AccountPostRepository;
import c0720g1be.service.AccountPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountPostServiceImpl implements AccountPostService {
    @Autowired
    private AccountPostRepository accountPostRepository;
    @Override
    public List<AccountPost> finAll() {
        return accountPostRepository.findAll();
    }

    @Override
    public void addAccountPost(AccountPost accountPost) {
        accountPostRepository.save(accountPost);
    }

    @Override
    public void removeAccountPost(Integer id) {
        accountPostRepository.deleteById(id);
    }
}
