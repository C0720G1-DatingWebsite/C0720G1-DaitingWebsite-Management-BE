package c0720g1be.service;

import c0720g1be.dto.AccountDTO;
import c0720g1be.entity.Account;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface AccountService {
    /**
     * Nguyen Bao Phuc
     * @param userName
     * @return
     */

    Account findAccountByUserName(String userName);

    Integer findIdUserByUserName(String userName);

    String existByUserName(String userName);

    void addNew(AccountDTO accountDTO) throws MessagingException, UnsupportedEncodingException;

    void saveNewPassword(String password, String code);

    Boolean findAccountByVerificationCode(String code);


}
