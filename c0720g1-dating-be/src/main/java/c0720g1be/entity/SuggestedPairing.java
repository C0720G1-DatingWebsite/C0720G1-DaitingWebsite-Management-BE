package c0720g1be.entity;

public class SuggestedPairing {

    private String hobbiesName;
    private String cityName;
    private boolean gender;
    private Integer maritalStatusId;
    private Integer accountId;
    private Integer size;

    public SuggestedPairing(String hobbiesName, String cityName, boolean gender, Integer maritalStatusId, Integer accountId, Integer size) {
        this.hobbiesName = hobbiesName;
        this.cityName = cityName;
        this.gender = gender;
        this.maritalStatusId = maritalStatusId;
        this.accountId = accountId;
        this.size = size;
    }

    public SuggestedPairing() {
    }

    public String getHobbiesName() {
        return hobbiesName;
    }

    public void setHobbiesName(String hobbiesName) {
        this.hobbiesName = hobbiesName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Integer getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(Integer maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

