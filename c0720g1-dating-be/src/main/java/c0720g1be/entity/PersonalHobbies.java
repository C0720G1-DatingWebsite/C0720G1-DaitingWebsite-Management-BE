package c0720g1be.entity;

import javax.persistence.*;

@Entity
@Table (name = "personal_hobbies", uniqueConstraints = {@UniqueConstraint(name = "PERSONAL_HOBBIES_UK",  columnNames = { "account_id", "hobbies_id" })})
public class PersonalHobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "hobbies_id")
    Hobbies hobbies;

    public PersonalHobbies() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies hobbies) {
        this.hobbies = hobbies;
    }
}
