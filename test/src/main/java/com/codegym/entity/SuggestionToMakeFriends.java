package c0720g1be.entity;
public class SuggestionToMakeFriends {

    private String hobbiesName;
    private String cityName;
    private Integer accountId;

    public SuggestionToMakeFriends(String hobbiesName, String cityName, Integer accountId) {
        this.hobbiesName = hobbiesName;
        this.cityName = cityName;
        this.accountId = accountId;
    }

    public SuggestionToMakeFriends() {
    }

    public String getHobbiesName() {
        return hobbiesName;
    }

    public String getCityName() {
        return cityName;
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

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
