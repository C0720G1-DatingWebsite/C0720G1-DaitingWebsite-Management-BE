package c0720g1be.entity;

import javax.persistence.*;

@Entity
@Table (name = "account_chat", uniqueConstraints = { @UniqueConstraint(name = "ACCOUNT_CHAT_UK", columnNames = { "account_id", "chat_id" }) })
public class AccountChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(columnDefinition = "TEXT")
    String content;

    @Column(columnDefinition = "DATETIME")
    String sentTime;

    @ManyToOne
            @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
            @JoinColumn(name = "chat_id")
    Chat chat;

    public AccountChat() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
