package c0720g1be.repository;

import c0720g1be.dto.AccountDTO;
import c0720g1be.dto.AccountDTO2;
import c0720g1be.entity.Account;
import c0720g1be.entity.City;
import c0720g1be.entity.Country;
import c0720g1be.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUserName(String userName);

    @Query(value = "select account.id as id from dating_application.account where user_name = ?1", nativeQuery = true)
    AccountDTO2 findIdUserByUserName(String userName);

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

    @Query(value = "update account as p set p.full_name =?1, p.address =?2, p.country_id = ?3, p.city_id = ?4, p.job_id = ?5, \n" +
            "p.audience =?6, p.account_describe = ?7, p.avatar =?8" +
            " where id =?9", nativeQuery = true)
    void updateInformation(String fullName, String address, Country countryID, City cityId
            , Job jobId, String audience, String avatar, Integer id);


}
