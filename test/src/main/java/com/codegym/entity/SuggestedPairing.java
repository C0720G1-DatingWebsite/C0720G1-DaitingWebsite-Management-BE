package c0720g1be.entity;

public class SuggestedPairing {

    private String hobbiesName;
    private String cityName;
    private boolean gender;
    private Integer maritalStatusId;
    private Integer accountId;

    public SuggestedPairing(String hobbiesName, String cityName, boolean gender, Integer maritalStatusId, Integer accountId) {
        this.hobbiesName = hobbiesName;
        this.cityName = cityName;
        this.gender = gender;
        this.maritalStatusId = maritalStatusId;
        this.accountId = accountId;
    }

    public SuggestedPairing() {
    }

    public String getHobbiesName() {
        return hobbiesName;
    }

    public String getCityName() {
        return cityName;
    }

    public boolean getGender() {
        return gender;
    }

    public Integer getMaritalStatusId() {
        return maritalStatusId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setHobbiesName(String hobbiesName) {
        this.hobbiesName = hobbiesName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setMaritalStatusId(Integer maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
