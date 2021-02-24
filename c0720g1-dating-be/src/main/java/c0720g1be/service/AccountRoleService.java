package c0720g1be.service;

import c0720g1be.entity.Account;
import c0720g1be.entity.AccountRole;

import java.util.List;

public interface AccountRoleService {

    List<AccountRole> findAllByAccount(Account account);

    void addRoleForAccount(AccountRole accountRole);

}
