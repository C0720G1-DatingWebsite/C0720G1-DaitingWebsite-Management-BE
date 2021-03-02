package c0720g1be.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_group",uniqueConstraints = { @UniqueConstraint(name = "ACCOUNT_GROUP_UK", columnNames = { "account_id", "group_id", "group_role_id" }) })
public class AccountGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
        @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
        @JoinColumn(name = "group_id")
    UserGroup userGroup;

    @ManyToOne
        @JoinColumn(name = "group_role_id")
    GroupRole groupRole;

    public AccountGroup() {
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

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public GroupRole getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GroupRole groupRole) {
        this.groupRole = groupRole;
    }
}
