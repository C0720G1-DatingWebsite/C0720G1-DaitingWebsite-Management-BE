package c0720g1be.service;

import c0720g1be.entity.Account;

public interface AccountService {

    /**
     * PhuocTC
     **/
    Account findByUsername(String username);

    /**
     * PhuocTC
     **/
    Account registerAccount(Account accountTemp);

    Account findById(Integer id);
}
