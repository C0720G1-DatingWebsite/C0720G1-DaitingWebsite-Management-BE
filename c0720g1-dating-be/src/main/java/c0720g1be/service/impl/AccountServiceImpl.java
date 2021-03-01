package c0720g1be.service.impl;

import c0720g1be.entity.Account;
import c0720g1be.repository.AccountRepository;
import c0720g1be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * PhuocTC
     **/
    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUserName(username);
    }

    /**
     * PhuocTC
     **/
    @Override
    public Account registerAccount(Account accountTemp) {
        return accountRepository.save(accountTemp);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account findByVetifyCode(String code) {
        return accountRepository.findByVetifyCode(code);
    }

    @Override
    public void sendMailForgotPassword(Account account) throws MessagingException, UnsupportedEncodingException {
        String subject = "Cảnh báo từ DATING WEBSITE";
        String mailContent = "";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(account.getEmail());
        helper.setFrom("hungdhpd01429@gmail.com","DATING WEBSITE - Website hẹn hò lớn nhất thế giới!");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + account.getFullName() + " ,<p>" + "<p> Nhấp vào đường dẫn sau để lấy lại mật khẩu:</p>" +
                "<h3><a href='http://localhost:4200/changed-password/"+ account.getVetifyCode() +"'>http://localhost:4200/changed-password/"+ account.getVetifyCode() +"</a></h3>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }
}
