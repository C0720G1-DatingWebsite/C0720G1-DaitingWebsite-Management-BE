package c0720g1be.entity;

import javax.persistence.*;

@Entity
@Table( uniqueConstraints = { @UniqueConstraint(name = "ACCOUNT_ROLE_UK", columnNames = { "account_id", "role_id" }) })
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    Account account;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    Role role;

    public AccountRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
