package c0720g1be.dto;

public class AccountWallDTO {
    Integer id;
    String userName;
    String fullName;
    String dateOfBirth;
    String address;
    Boolean gender;
    Boolean statusAccount;
    String email;
    String accountDescribe;
    Integer countryId;
    Integer cityId;
    Integer jobId;
    Integer maritalStatusId;
    Boolean audience;

    public AccountWallDTO() {
    }

    public AccountWallDTO(Integer id, String userName, String fullName, String dateOfBirth, String address, Boolean gender, Boolean statusAccount, String email, String accountDescribe, Integer countryId, Integer cityId, Integer jobId, Integer maritalStatusId, Boolean audience) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gender = gender;
        this.statusAccount = statusAccount;
        this.email = email;
        this.accountDescribe = accountDescribe;
        this.countryId = countryId;
        this.cityId = cityId;
        this.jobId = jobId;
        this.maritalStatusId = maritalStatusId;
        this.audience = audience;
    }

    public Boolean getAudience() {
        return audience;
    }

    public void setAudience(Boolean audience) {
        this.audience = audience;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountDescribe() {
        return accountDescribe;
    }

    public void setAccountDescribe(String accountDescribe) {
        this.accountDescribe = accountDescribe;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(Integer maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public Boolean getStatusAccount() {
        return statusAccount;
    }

    public void setStatusAccount(Boolean statusAccount) {
        this.statusAccount = statusAccount;
    }
}
