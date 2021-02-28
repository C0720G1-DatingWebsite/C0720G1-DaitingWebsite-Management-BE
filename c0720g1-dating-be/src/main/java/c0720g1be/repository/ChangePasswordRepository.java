package c0720g1be.repository;

import c0720g1be.dto.AccountChangePassword;
import c0720g1be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChangePasswordRepository extends JpaRepository<Account,Integer> {

    /**
     * Võ Thành Tín
     * Change Password
     *
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "Update account as a set a.password = ?1 where a.id = ?2",nativeQuery = true)
    void changePassword(String password, Integer id);

    /**
     * Võ Thành Tín
     * get account by id
     *
     */
    @Query(value = "select * from account where account.id = ?1",nativeQuery = true)
    Account findAccountById(Integer id);

    /**
     * Võ Thành Tín
     * get AccountDTO by id
     *
     */
    @Query(value = "select account.id as idAccount, account.user_name as userName, account.password as password, account.avatar as avatar, account.status_id as status" +
            " from account where account.id = ?1",nativeQuery = true)
    AccountChangePassword findAccountDTOById(Integer id);

    /**
     * Võ Thành Tín: Setting Status
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "update account as a set a.status_id = ?1 where a.id = ?2 ", nativeQuery = true)
    void settingStatus(Integer statusId, Integer accountId);



    /**
     * Võ Thành Tín: Change Avatar
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "update account as a set a.avatar = ?1 where a.id = ?2",nativeQuery = true)
    void changeAvatar(String avatar, Integer id);
}

