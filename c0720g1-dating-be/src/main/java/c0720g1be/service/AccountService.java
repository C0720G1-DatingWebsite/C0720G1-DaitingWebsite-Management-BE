package c0720g1be.service;

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

    /**
     * PhuocTC
     **/
    Account findByEmail(String email);

    /**
     * PhuocTC
     **/
    Account findByVetifyCode(String code);


    void sendMailForgotPassword(Account account) throws MessagingException, UnsupportedEncodingException;
}
