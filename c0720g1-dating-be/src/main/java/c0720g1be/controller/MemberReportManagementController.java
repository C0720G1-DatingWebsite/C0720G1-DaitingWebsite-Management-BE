package c0720g1be.controller;

import c0720g1be.dto.GetFeedbackDTO;
import c0720g1be.dto.MemberDTO;
import c0720g1be.dto.ReportMemberDTO;
import c0720g1be.dto.ReportMemberInterfaceDTO;
import c0720g1be.entity.Account;
import c0720g1be.entity.Feedback;
import c0720g1be.entity.ReportContent;
import c0720g1be.service.AccountService;
import c0720g1be.service.MemberReportManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MemberReportManagementController {
    @Autowired
    private MemberReportManagementService memberReportManagementService;
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AccountService accountService;
    /*
    * HungDH - trang quan ly thanh vien
     */
    @RequestMapping(value = "/member", method=RequestMethod.GET)
    public ResponseEntity<List<MemberDTO>> getAllMember(
            @RequestParam(defaultValue = "") String userNameSearch,
            @RequestParam(defaultValue = "") String dateOfBirthSearch,
            @RequestParam(defaultValue = "") String dateRegisterSearch,
            @RequestParam Integer size
    ) {
        List<MemberDTO> memberDTOList;
        if (!userNameSearch.equals("") || !dateOfBirthSearch.equals("") || !dateRegisterSearch.equals("")) {
            return new ResponseEntity<>(memberReportManagementService.findAccountByUserNameAndDateOfBirthAndDateOfBirth
                    ("%" + userNameSearch + "%", "%" + dateOfBirthSearch + "%", "%" + dateRegisterSearch + "%"), (HttpStatus.OK));
        } else {
            memberDTOList = memberReportManagementService.findAllMember(size);
        }
        if (memberDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberDTOList, HttpStatus.OK);
    }
    /*
    HungDH - hien thi list report content
     */
    @GetMapping("/report-content")
    public ResponseEntity<List<ReportContent>> getAllReportContent(){
        List<ReportContent> reportContents = memberReportManagementService.findAllByReportContent();
        if (reportContents.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reportContents, HttpStatus.OK);
    }
    /*
    * HungDH - tim thanh vien theo id
     */
    @GetMapping("/find-member-by-id/{accountId}")
    public ResponseEntity<Account> findMemberById(@PathVariable Integer accountId){
        memberReportManagementService.findMemberById(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /*
     * HungDH - canh bao thanh vien
     */
    @GetMapping("/report-member-list/{accountId}")
    public ResponseEntity<List<ReportMemberInterfaceDTO>> reportMemberList(@PathVariable Integer accountId){
        List<ReportMemberInterfaceDTO> reportMemberDTOList = memberReportManagementService.reportMemberList(accountId);
        if (reportMemberDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reportMemberDTOList, HttpStatus.OK);
    }
    /*
    * HungDH
     */
    @GetMapping("/send-warning-message/{id}")
    public ResponseEntity<?> sendEmail(@PathVariable Integer id) throws MessagingException, UnsupportedEncodingException {
        Account account = memberReportManagementService.findMemberById(id);
        if (!account.getEnable()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String subject = "Cảnh báo từ DATING WEBSITE";
        String mailContent = "";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(account.getEmail());
        helper.setFrom("hungdhpd01429@gmail.com","DATING WEBSITE - Website hẹn hò lớn nhất thế giới!");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + account.getUserName() + " ,<p>" + "<p> Chúng tôi nhận thấy bạn đã vi phạm qui chế của DATING WEBSITE:</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/lock-account-one-week/{accountId}")
    public ResponseEntity<?> lockAccountOneWeek(@PathVariable Integer accountId) throws MessagingException, UnsupportedEncodingException {
        Account account = memberReportManagementService.findMemberById(accountId);
        System.out.println(account.getEnable());
        if (!account.getEnable()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String subject = "Cảnh báo từ DATING WEBSITE";
        String mailContent = "";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(account.getEmail());
        helper.setFrom("hungdhpd01429@gmail.com","DATING WEBSITE - Website hẹn hò lớn nhất thế giới!");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + account.getUserName() + " ,<p>" + "<p> Chúng tôi nhận thấy bạn đã vi phạm qui chế của DATING WEBSITE:</p>" +
                "<h3><a href=''>Bạn bị khóa tài khoản 1 tuần</a></h3>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
        memberReportManagementService.lockAccountOneWeek(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/lock-account-one-month/{accountId}")
    public ResponseEntity<?> lockAccountOneMonth(@PathVariable Integer accountId) throws MessagingException, UnsupportedEncodingException {
        Account account = memberReportManagementService.findMemberById(accountId);
        System.out.println(account.getEnable());
        if (!account.getEnable()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String subject = "Cảnh báo từ DATING WEBSITE";
        String mailContent = "";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(account.getEmail());
        helper.setFrom("hungdhpd01429@gmail.com","DATING WEBSITE - Website hẹn hò lớn nhất thế giới!");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + account.getUserName() + " ,<p>" + "<p> Chúng tôi nhận thấy bạn đã vi phạm qui chế của DATING WEBSITE:</p>" +
                "<h3><a href=''>Bạn bị khóa tài khoản 30 ngay</a></h3>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
        memberReportManagementService.lockAccountOnemonth(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/lock-account-forever/{accountId}")
    public ResponseEntity<?> lockAccountForever(@PathVariable Integer accountId) throws MessagingException, UnsupportedEncodingException {
        Account account = memberReportManagementService.findMemberById(accountId);
        System.out.println(account.getEnable());
        if (!account.getEnable()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String subject = "Cảnh báo từ DATING WEBSITE";
        String mailContent = "";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(account.getEmail());
        helper.setFrom("hungdhpd01429@gmail.com","DATING WEBSITE - Website hẹn hò lớn nhất thế giới!");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + account.getUserName() + " ,<p>" + "<p> Chúng tôi nhận thấy bạn đã vi phạm qui chế của DATING WEBSITE:</p>" +
                "<h3><a href=''>Bạn đã bị khóa tài khoản vĩnh viễn</a></h3>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
        memberReportManagementService.lockAccountForever(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/send-report-feedback-account")
    public ResponseEntity<?> sendReportFeedbackAccount(@RequestBody ReportMemberDTO report){
        Account accountTarget = accountService.findByUsername(report.getAccountTarget());
        Account accountVictim = accountService.findByUsername(report.getAccountVictim());
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        memberReportManagementService.warningMember(report.getDateReport(), accountTarget.getId(),
                accountVictim.getId(), Integer.parseInt(report.getReportContent()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/get-feedback")
    public ResponseEntity<List<GetFeedbackDTO>> findAllFeedback(){
        List<GetFeedbackDTO> getFeedbackDTOS = memberReportManagementService.findAllFeedback();
        if (getFeedbackDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getFeedbackDTOS, HttpStatus.OK);
    }
}
