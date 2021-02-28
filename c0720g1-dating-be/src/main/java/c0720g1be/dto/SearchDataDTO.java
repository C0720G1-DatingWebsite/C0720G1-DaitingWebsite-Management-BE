package c0720g1be.dto;

public class SearchDataDTO {
    String name;
    String job;
    String hobbies;
    String startYear;
    String endYear;
    int gender;
    int city;
    int currentPage;
    int maxPage;
    int totalResult;

    public SearchDataDTO() {
    }

    public SearchDataDTO(String name, String job, String hobbies, String startYear, String endYear, int gender, int city, int currentPage, int maxPage, int totalResult) {
        this.name = name;
        this.job = job;
        this.hobbies = hobbies;
        this.startYear = startYear;
        this.endYear = endYear;
        this.gender = gender;
        this.city = city;
        this.currentPage = currentPage;
        this.maxPage = maxPage;
        this.totalResult = totalResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    @Override
    public String toString() {
        return "SearchDataDTO{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", startYear='" + startYear + '\'' +
                ", endYear='" + endYear + '\'' +
                ", gender=" + gender +
                ", city=" + city +
                ", currentPage=" + currentPage +
                ", maxPage=" + maxPage +
                ", totalResult=" + totalResult +
                '}';
    }
}
