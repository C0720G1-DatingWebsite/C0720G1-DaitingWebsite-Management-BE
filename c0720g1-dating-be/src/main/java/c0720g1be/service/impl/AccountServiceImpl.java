package c0720g1be.service.impl;

import c0720g1be.entity.Account;
import c0720g1be.repository.AccountRepository;
import c0720g1be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUserName(username);
    }

    @Override
    public Account registerAccount(Account accountTemp) {
        return accountRepository.save(accountTemp);
    }
}
