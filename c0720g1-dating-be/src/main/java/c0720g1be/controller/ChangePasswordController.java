package c0720g1be.controller;

import c0720g1be.dto.AccountChangePassword;
import c0720g1be.entity.Account;
import c0720g1be.service.IChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ChangePasswordController {

    @Autowired
    private IChangePasswordService iChangePasswordService;

    /**
     * Võ Thành Tín: ChangePassword
     */
    @RequestMapping(value = "/change-password/{id}/{pass}", method = RequestMethod.PATCH)
    public ResponseEntity<String> changePassword(@PathVariable("id") Integer id, @PathVariable("pass") String password) {
        if (iChangePasswordService.changePassword(password, id)) {
            return new ResponseEntity<String>(password,HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }


    /**
     * Võ Thành Tín: Check Password
     */
    @RequestMapping(value = "/check-password/{id}/{pass}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean checkPassword(@PathVariable Integer id,@PathVariable String pass){
        Account account = this.iChangePasswordService.findAccountById(id);
//        if(account.getPassword().equals(pass)){
//            return true;
//
//        }else {
//            return false;
//        }
        return account.getPassword().equals(pass);
    }

    /**
     * Võ Thành Tín: Find By Id
     */

    @RequestMapping(value = "/find-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountChangePassword> findAccountDTOById(@PathVariable Integer id){
        AccountChangePassword account = this.iChangePasswordService.findAccountDTOById(id);
        if (id == null){
            return new ResponseEntity<AccountChangePassword>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AccountChangePassword>(account,HttpStatus.OK);
    }
}

