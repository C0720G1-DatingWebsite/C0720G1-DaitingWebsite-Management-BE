package c0720g1be.service.impl;

import c0720g1be.dto.AccountMainDTO;
import c0720g1be.dto.AccountMainDTO2;
import c0720g1be.entity.Account;
import c0720g1be.repository.AccountRepository;
import c0720g1be.repository.RoleRegisterRepository;
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
    public Account findById(Integer id) {
        return accountRepository.findByIdAccount(id);
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


    /**
     * Nguyen Bao Phuc
     */


    @Override
    public Account findAccountByUserName(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }

    @Override
    public AccountMainDTO2 findIdUserByUserName(String userName) {
        return accountRepository.findIdUserByUserName(userName);
    }

    @Override
    public Account updateInformation(Account account) {
        this.accountRepository.updateInformation(account.getFullName(), account.getAddress(), account.getCountry(), account.getCity(), account.getJob(), account.getAccountDescribe(), account.getAvatar(), account.getId());
        return account;
    }


    @Override
    public String existByUserName(String userName) {
        return accountRepository.existsByUserName(userName);
    }


    @Override
    public void addNew(AccountMainDTO accountMainDTO) throws MessagingException, UnsupportedEncodingException {
        String randomCode = RandomString.make(64);
        accountRepository.addNew(accountMainDTO.getUserName(), accountMainDTO.getPassword(), true, accountMainDTO.getVerificationCode(), accountMainDTO.getDateOfBirth(), accountMainDTO.getGender());
        sendVerificationEmail(accountMainDTO.getUserName(), randomCode);
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

    /**
     * Nguyen Bao Phuc
     */

    @Autowired
    private RoleRegisterRepository roleRegisterRepository;

    @Override
    public void setDefaultRole(Integer accountId, Integer roleId) {
        roleRegisterRepository.setDefaultRole(accountId, roleId);
    }
}
