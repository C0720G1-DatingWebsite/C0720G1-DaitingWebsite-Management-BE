package c0720g1be.service.impl;

import c0720g1be.entity.Account;
import c0720g1be.entity.AccountRole;
import c0720g1be.repository.AccountRepository;
import c0720g1be.repository.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);

        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the databases" );
        }

        List<AccountRole> accountRoleList = accountRoleRepository.findAllByAccount(account);

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        if (accountRoleList != null) {
            for (AccountRole accountRole: accountRoleList) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(accountRole.getRole().getName());
                grantedAuthorityList.add(grantedAuthority);
            }
        }

        return new User(account.getUserName(), account.getPassword(), grantedAuthorityList);
    }
}
