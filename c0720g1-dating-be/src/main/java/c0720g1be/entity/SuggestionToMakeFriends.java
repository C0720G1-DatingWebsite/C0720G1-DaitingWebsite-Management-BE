package c0720g1be.entity;
public class SuggestionToMakeFriends {

    private String hobbiesName;
    private String cityName;
    private Integer accountId;
    private Integer size;

    public SuggestionToMakeFriends(String hobbiesName, String cityName, Integer accountId, Integer size) {
        this.hobbiesName = hobbiesName;
        this.cityName = cityName;
        this.accountId = accountId;
        this.size = size;
    }

    public SuggestionToMakeFriends() {
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
