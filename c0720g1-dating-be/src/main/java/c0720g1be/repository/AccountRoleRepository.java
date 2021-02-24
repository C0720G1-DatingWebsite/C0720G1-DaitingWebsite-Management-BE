package c0720g1be.repository;

import c0720g1be.entity.Account;
import c0720g1be.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer> {

    List<AccountRole> findAllByAccount(Account account);
}
