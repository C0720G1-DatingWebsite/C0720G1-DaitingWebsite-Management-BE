package c0720g1be.dto;

import c0720g1be.entity.City;
import c0720g1be.entity.Country;
import c0720g1be.entity.Job;

public class informationAccountDTO {

    String fullName;
    String address;
    Country country;
    City city;
    Job job;
    Boolean audience;
    String accountDescribe;
    String avatar;

    public informationAccountDTO(String fullName, String address, Country country, City city, Job job, Boolean audience, String accountDescribe, String avatar) {
        this.fullName = fullName;
        this.address = address;
        this.country = country;
        this.city = city;
        this.job = job;
        this.audience = audience;
        this.accountDescribe = accountDescribe;
        this.avatar = avatar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Boolean getAudience() {
        return audience;
    }

    public void setAudience(Boolean audience) {
        this.audience = audience;
    }

    public String getAccountDescribe() {
        return accountDescribe;
    }

    public void setAccountDescribe(String accountDescribe) {
        this.accountDescribe = accountDescribe;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
