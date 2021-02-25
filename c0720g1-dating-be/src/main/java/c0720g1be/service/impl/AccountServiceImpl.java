package c0720g1be.service.impl;

import c0720g1be.dto.AccountDTO;
import c0720g1be.entity.Account;
import c0720g1be.repository.AccountRepository;
import c0720g1be.service.AccountService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class AccountServiceImpl implements AccountService {
    /**
     * Nguyen Bao Phuc
     */

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    JavaMailSender javaMailSender;


    @Override
    public Account findAccountByUserName(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }

    @Override
    public Integer findIdUserByUserName(String userName) {
        return accountRepository.findIdUserByUserName(userName);
    }

    @Override
    public String existByUserName(String userName) {
        return accountRepository.existsByUserName(userName);
    }


    @Override
    public void addNew(AccountDTO accountDTO) throws MessagingException, UnsupportedEncodingException {
        String randomCode = RandomString.make(64);
        accountRepository.addNew(accountDTO.getUserName(), accountDTO.getPassword(), true, accountDTO.getVerificationCode(), accountDTO.getDateOfBirth(), accountDTO.getGender());
        sendVerificationEmail(accountDTO.getUserName(), randomCode);
    }

    private void sendVerificationEmail(String userName, String randomCode) throws MessagingException, UnsupportedEncodingException {
        String subject = "Hãy xác thực email của bạn!";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verification?code=" + randomCode;

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(userName);
        helper.setFrom("phucnguyenty1694@gmail.com", "TINTINDER");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + userName + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link Xác thực( nhấn vào đây)!</a></h3>" +
                "<p>TINTINDER</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }

    @Override
    public void saveNewPassword(String password, String code) {
        accountRepository.saveNewPassword(password, code);
    }

    @Override
    public Boolean findAccountByVerificationCode(String code) {
        Account account = accountRepository.findAccountByVerificationCode(code);
        if (account  == null || account.getEnable()){
            return false;
        }else {
            account.setEnable(true);
            account.setVerificationCode(null);
            accountRepository.save(account);
            return true;
        }
    }


//    @Override
//    public void saveAccountOne(AccountDTO accountDTO) {
//        this.accountRepository.addNew(accountDTO.getUserName(), accountDTO.getPassword(),  accountDTO.getIsEnabled(), accountDTO.getVerificationCode(), accountDTO.getDateOfBirth(), accountDTO.getGender());
//    }


}
