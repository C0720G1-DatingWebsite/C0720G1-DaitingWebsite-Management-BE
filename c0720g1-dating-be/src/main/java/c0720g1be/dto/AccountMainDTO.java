package c0720g1be.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AccountMainDTO {
    Integer id;
    @NotBlank
    @Length(min = 6, max = 32)
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "wrong format, should be abc@abc.com ")
    String userName;
    @NotBlank
    @Length(min = 8, max = 32)
    String password;
    String verificationCode;
    Boolean isEnabled;
    String dateOfBirth;
    Boolean gender;

    public AccountMainDTO(Integer id, String userName, String password, String verificationCode, Boolean isEnabled, String dateOfBirth, Boolean gender) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.verificationCode = verificationCode;
        this.isEnabled = isEnabled;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
