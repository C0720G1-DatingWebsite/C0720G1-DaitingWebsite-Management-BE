package c0720g1be.dto;

public class DateUnlockAccountDTO {
    Integer accountId;
    String user_name;
    String date_unban;

    public DateUnlockAccountDTO() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDate_unban() {
        return date_unban;
    }

    public void setDate_unban(String date_unban) {
        this.date_unban = date_unban;
    }
}
