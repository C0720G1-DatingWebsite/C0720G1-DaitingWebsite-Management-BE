package c0720g1be.entity;

import javax.persistence.*;

@Entity
@Table( uniqueConstraints = { @UniqueConstraint(name = "FRIEND_UK", columnNames = { "account_id", "friend_id" }) })
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    Account account;

    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false)
    Account friend;

    @ManyToOne
    @JoinColumn(name = "state_id")
    State state;

    public Friend() {
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

    public Account getFriend() {
        return friend;
    }

    public void setFriend(Account friend) {
        this.friend = friend;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
