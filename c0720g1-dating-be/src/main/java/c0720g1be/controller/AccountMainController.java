package c0720g1be.controller;

import c0720g1be.dto.AccountMainDTO;
import c0720g1be.dto.AccountMainDTO2;
import c0720g1be.dto.InformationAccountDTO;
import c0720g1be.entity.Account;
import c0720g1be.payload.reponse.MessageResponse;
import c0720g1be.payload.request.VerifyRequest;
import c0720g1be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AccountMainController {

//    @Autowired
//    private PasswordEncoder encoder;

    @Autowired
    private AccountService accountService;


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
    public ResponseEntity<?> registerUser(@Valid @RequestBody AccountMainDTO accountMainDTO)throws MessagingException, UnsupportedEncodingException{
        if (accountService.existByUserName(accountMainDTO.getUserName()) != null){
            return ResponseEntity.badRequest().body(new MessageResponse("Tên email(tài khoản) đã được sử dụng!"));
        }
        //Create new user account

        accountService.addNew(accountMainDTO);

        AccountMainDTO2 idAccountAfterCreated = accountService.findIdUserByUserName(accountMainDTO.getUserName());

            accountService.setDefaultRole(idAccountAfterCreated.getId(), 1);

        return ResponseEntity.ok(new MessageResponse("Đăng ký tài khoản thành công!"));

    }

    /**
     * Nguyen Bao Phuc
     *
     * @param code
     * @return
     */
    @PostMapping( value = "/verify")
    public ResponseEntity<?> VerifyEmail(@RequestBody VerifyRequest code){
        Boolean isVerified = accountService.findAccountByVerificationCode(code.getCode());
        if (isVerified){
            return ResponseEntity.ok(new MessageResponse("activated"));
        }else {
            return ResponseEntity.ok(new MessageResponse("error"));
        }
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<?> updateInformation(@RequestBody InformationAccountDTO informationAccountDTO, BindingResult bindingResult, @PathVariable Account id){
        Account account1 = accountService.updateInformation(id);

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        if (account1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            account1.setFullName(informationAccountDTO.getFullName());
            account1.setAddress(informationAccountDTO.getAddress());
            account1.setCountry(informationAccountDTO.getCountry());
            account1.setCity(informationAccountDTO.getCity());
            account1.setJob(informationAccountDTO.getJob());
            account1.setAudience(informationAccountDTO.getAudience());
            account1.setAccountDescribe(informationAccountDTO.getAccountDescribe());
            account1.setAvatar(informationAccountDTO.getAvatar());
            accountService.updateInformation(account1);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

}
