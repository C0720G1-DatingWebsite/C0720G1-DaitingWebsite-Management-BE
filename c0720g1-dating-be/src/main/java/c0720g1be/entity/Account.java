package c0720g1be.entity;

import javax.persistence.*;

@Entity
@Table (uniqueConstraints = { @UniqueConstraint(name = "USERNAME_UK", columnNames = "username") })
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String userName;
    String password;
    String fullName;
    @Column(columnDefinition = "Date")
    String dateOfBirth;
    String address;
    Boolean isEnable;
    Boolean gender;
    Boolean audience;
    @Column(columnDefinition = "TEXT")
    String accountDescribe;
    @Column(columnDefinition = "TEXT")
    String avatar;
    @Column(columnDefinition = "DATE")
    String dateRegister;
    @Column(columnDefinition = "TEXT")
    String backgroundImage;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    @ManyToOne
    @JoinColumn (name = "city_id")
    City city;

    @OneToOne
    @JoinColumn (name = "job_id")
    Job job;

    @ManyToOne
    @JoinColumn (name = "status_id")
    Status status;

    @ManyToOne
    @JoinColumn (name = "marital_status_id")
    MaritalStatus maritalStatus;

    public Account() {
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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
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

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
