package c0720g1be.service.impl;

import c0720g1be.dto.AccountChangePassword;
import c0720g1be.entity.Account;
import c0720g1be.repository.ChangePasswordRepository;
import c0720g1be.service.IChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ChangPasswordServiceImpl implements IChangePasswordService {

    @Autowired
    private ChangePasswordRepository changePasswordRepository;


    /**
     * Võ Thành Tín: ChangePassword
     */
    @Override
    public Boolean changePassword(String password, Integer id) {
        try {
            this.changePasswordRepository.changePassword(password, id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Võ Thành Tín: Find Account By Id
     */
    @Override
    public Account findAccountById(Integer id) {
        return changePasswordRepository.findAccountById(id);
    }

    @Override
    public AccountChangePassword findAccountDTOById(Integer id) {
        return this.changePasswordRepository.findAccountDTOById(id);
    }


    /**
     * Võ Thành Tín: Setting Status
     */
    @Override
    public Boolean settingStatus(Integer statusId, Integer accountId) {
        try {
            changePasswordRepository.settingStatus(statusId, accountId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean changeAvatar(String avatar, Integer id) {
        try{
            changePasswordRepository.changeAvatar(avatar,id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}

