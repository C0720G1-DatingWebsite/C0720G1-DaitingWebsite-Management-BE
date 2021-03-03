package c0720g1be.entity;

import javax.persistence.*;

@Entity
public class CustomView {
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
            @JoinColumn(name = "post_id")
    Post post;

    public CustomView() {
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}
