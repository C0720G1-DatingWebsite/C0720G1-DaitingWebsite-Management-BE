package c0720g1be.service.impl;

import c0720g1be.entity.Account;
import c0720g1be.entity.AccountRole;
import c0720g1be.repository.AccountRoleRepository;
import c0720g1be.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Override
    public List<AccountRole> findAllByAccount(Account account) {
        return accountRoleRepository.findAllByAccount(account);
    }

    @Override
    public void addRoleForAccount(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }
}
