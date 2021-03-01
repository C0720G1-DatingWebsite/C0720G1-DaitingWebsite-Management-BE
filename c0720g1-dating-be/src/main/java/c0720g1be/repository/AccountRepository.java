package c0720g1be.repository;

import c0720g1be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * PhuocTC
     **/
    Account findByUserName(String userName);

    Account findByEmail(String email);

    Account findByVetifyCode(String code);
}
