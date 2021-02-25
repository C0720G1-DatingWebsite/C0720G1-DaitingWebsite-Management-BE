package c0720g1be.controller;

import c0720g1be.dto.AccountDTO;
import c0720g1be.entity.Account;
import c0720g1be.payload.reponse.MessageResponse;
import c0720g1be.payload.request.SignupRequest;
import c0720g1be.payload.request.VerifyRequest;
import c0720g1be.service.AccountService;
import c0720g1be.service.RoleService;
import jdk.jfr.internal.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http:/localhost:4200")
public class AccountController {

    @Autowired
     private AccountService accountService;

//    @Autowired
//    private PasswordEncoder encoder;

    @Autowired
    private RoleService roleService;


    /**
     * Nguyen Bao Phuc
     * đăng ký tài khoản mới
     /
     * @param
     * @return
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AccountDTO accountDTO)throws MessagingException, UnsupportedEncodingException{
        if (accountService.existByUserName(accountDTO.getUserName()) != null){
            return ResponseEntity.badRequest().body(new MessageResponse("Tên email(tài khoản) đã được sử dụng!"));
        }
        //Create new user account
        accountService.addNew(accountDTO);

        Integer idAccountAfterCreated = accountService.findIdUserByUserName(accountDTO.getUserName());

            roleService.setDefaultRole(idAccountAfterCreated, 1);


        return ResponseEntity.ok(new MessageResponse("Đăng ký tài khoản thành công!"));

    }

    /**
     * Nguyen Bao Phuc
     *
     * @param code
     * @return
     */
    @PostMapping("/verify")
    public ResponseEntity<?> VerifyEmail(@RequestBody VerifyRequest code){
        Boolean isVerified = accountService.findAccountByVerificationCode(code.getCode());
        if (isVerified){
            return ResponseEntity.ok(new MessageResponse("activated"));
        }else {
            return ResponseEntity.ok(new MessageResponse("error"));
        }
    }

}
