package c0720g1be.repository;

import c0720g1be.dto.AccountMainDTO2;
import c0720g1be.entity.Account;
import c0720g1be.entity.City;
import c0720g1be.entity.Country;
import c0720g1be.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    /**
     * Phuc
     * */

    Account findAccountByUserName(String userName);

    @Query(value = "select account.id as id from dating_application.account where user_name = ?1", nativeQuery = true)
    AccountMainDTO2 findIdUserByUserName(String userName);

    @Query(value = "select user_name from dating_application.account where user_name = ?1", nativeQuery = true)
    String existsByUserName(String userName);


    @Modifying
    @Query(value = "insert into account(user_name, password, is_enable, verification_code, date_of_birth, gender) values(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void addNew(String userName, String password, Boolean isEnable, String verificationCode, String dateOfBirth, Boolean gender);

    @Modifying
    @Query(value = "update account set password = ?1, verification_code = null where verification_code = ?2", nativeQuery = true)
    void saveNewPassword(String password, String code);

    @Query(value = "select * from account where verification_code = ?1", nativeQuery = true)
    Account findAccountByVerificationCode(String verifyCode);

    @Modifying
    @Query(value = "update account as p set p.full_name =?1, p.address =?2, p.country_id = ?3, p.city_id = ?4, p.job_id = ?5, \n" +
            "p.audience =?6, p.account_describe = ?7, p.avatar =?8" +
            " where id =?9", nativeQuery = true)
    void updateInformation(String fullName, String address, Country countryID, City cityId
            , Job jobId, String audience, String avatar, Integer id);

    @Modifying
    @Query(value = "UPDATE `account` SET " +
            "`account_describe` = ?1, `address` = ?2, `fullName` = ?3, `date_of_birth` = ?4, " +
            "`gender` = ?5, `city_id` = ?6, `country_id` = ?7, `job_id` = ?8, " +
            "`marital_status_id` = ?9, `email` = ?10, 'audience' = ?11 WHERE (`id` = ?12) ", nativeQuery = true)
    void updateAccount(String accountDescribe, String address, String fullName, String dateOfBirth,
                       Boolean gender, Integer city, Integer country, Integer job,
                       Integer maritalStatus, String email, Boolean audience, Integer id);
}
