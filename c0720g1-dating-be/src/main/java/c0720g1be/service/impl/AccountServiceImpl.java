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

    /**
     * PhuocTC
     **/
    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUserName(username);
    }

    /**
     * PhuocTC
     **/
    @Override
    public Account registerAccount(Account accountTemp) {
        return accountRepository.save(accountTemp);
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findByIdAccount(id);
    }
}
