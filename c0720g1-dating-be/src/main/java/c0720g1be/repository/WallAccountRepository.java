package c0720g1be.repository;

import c0720g1be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface WallAccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT * FROM `account` where `account`.`id` = ?1", nativeQuery = true)
    Account findByIdAccount(Integer id);
}
