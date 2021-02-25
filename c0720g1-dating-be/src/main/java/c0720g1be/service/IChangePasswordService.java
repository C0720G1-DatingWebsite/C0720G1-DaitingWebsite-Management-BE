package c0720g1be.service;


import c0720g1be.dto.AccountChangePassword;
import c0720g1be.entity.Account;

public interface IChangePasswordService {

    /**
     * Võ Thành Tín: ChangePassword
     */
    Boolean changePassword(String password, Integer id);


    /**
     * Võ Thành Tín: Find Account by Id
     */
    Account findAccountById(Integer id);


    /**
     * Võ Thành Tín: Find AccountDTO by Id
     */
    AccountChangePassword findAccountDTOById(Integer id);

    /**
     * Võ Thành Tín: Setting Status
     */
    Boolean settingStatus(Integer statusId, Integer accountId);


    /**
     * Võ Thành Tín: Setting Status
     */
    Boolean changeAvatar(String avatar, Integer id);
}

