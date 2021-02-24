package c0720g1be.service;

import c0720g1be.entity.Account;

public interface AccountService {

    Account findByUsername(String username);

    Account registerAccount(Account accountTemp);
}
