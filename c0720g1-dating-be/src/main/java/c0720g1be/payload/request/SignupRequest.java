package c0720g1be.payload.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SignupRequest {
    /**
     * Nguyen Bao Phuc
     */
    @NotBlank
    @Length(min = 6, max = 32)
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "wrong format, should be abc@abc.com ")
    private String userName;
    @NotBlank
    @Length(min = 8, max = 32)
    private String password;

    public SignupRequest(String userName, String password){
        this.userName = userName;
        this.password = password;
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
}
