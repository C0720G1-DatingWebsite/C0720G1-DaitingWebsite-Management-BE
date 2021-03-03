package c0720g1be.repository;

import c0720g1be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * PhuocTC
     **/
    Account findByUserName(String userName);

    /**
     * LuyenNT
     */
    @Query(value = "select * from account where id = ?", nativeQuery = true)
    Account findByIdAccount(Integer id);


    Account findByEmail(String email);

    Account findByVetifyCode(String code);
}
