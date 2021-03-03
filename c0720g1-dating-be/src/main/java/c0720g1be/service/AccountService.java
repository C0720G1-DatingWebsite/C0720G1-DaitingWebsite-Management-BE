package c0720g1be.service;

import c0720g1be.dto.AccountDTO;
import c0720g1be.dto.AccountDTO2;
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

    AccountDTO2 findIdUserByUserName(String userName);

    Account updateInformation(Account id);

    String existByUserName(String userName);

    void addNew(AccountDTO accountDTO) throws MessagingException, UnsupportedEncodingException;

    void saveNewPassword(String password, String code);

    Boolean findAccountByVerificationCode(String code);


}
