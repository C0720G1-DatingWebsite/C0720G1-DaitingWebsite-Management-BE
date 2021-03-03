package c0720g1be.service;

import c0720g1be.dto.AccountMainDTO;
import c0720g1be.dto.AccountMainDTO2;
import c0720g1be.entity.Account;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface AccountService {

    /**
     * PhuocTC
     **/
    Account findByUsername(String username);

    /**
     * PhuocTC
     **/
    Account registerAccount(Account accountTemp);

    Account findById(Integer id);
    /**
     * PhuocTC
     **/
    Account findByEmail(String email);

    /**
     * PhuocTC
     **/
    Account findByVetifyCode(String code);


    void sendMailForgotPassword(Account account) throws MessagingException, UnsupportedEncodingException;

    /**
     * Nguyen Bao Phuc
     * @param userName
     * @return
     */

    Account findAccountByUserName(String userName);

    AccountMainDTO2 findIdUserByUserName(String userName);

    Account updateInformation(Account id);

    String existByUserName(String userName);

    void addNew(AccountMainDTO accountMainDTO) throws MessagingException, UnsupportedEncodingException;

    void saveNewPassword(String password, String code);

    Boolean findAccountByVerificationCode(String code);

    /**
     * Nguyen Bao Phuc
     * @param accountId
     * @param roleId
     */

    void setDefaultRole(Integer accountId, Integer roleId);

}
