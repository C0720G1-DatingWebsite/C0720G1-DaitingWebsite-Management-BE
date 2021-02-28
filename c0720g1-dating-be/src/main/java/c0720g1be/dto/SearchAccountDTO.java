package c0720g1be.dto;

public class SearchAccountDTO {
    int id;
    String fullName;
    String avatar;
    String backgroundImage;
    String accountDescribe;
    int postCount;
    int friendCount;
    int likeCount;

    public SearchAccountDTO() {
    }

    public SearchAccountDTO(int id, String fullName, String avatar, String backgroundImage, String accountDescribe, int postCount, int friendCount, int likeCount) {
        this.id = id;
        this.fullName = fullName;
        this.avatar = avatar;
        this.backgroundImage = backgroundImage;
        this.accountDescribe = accountDescribe;
        this.postCount = postCount;
        this.friendCount = friendCount;
        this.likeCount = likeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAccountDescribe() {
        return accountDescribe;
    }

    public void setAccountDescribe(String accountDescribe) {
        this.accountDescribe = accountDescribe;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getFriendCount() {
        return friendCount;
    }

    public void setFriendCount(int friendCount) {
        this.friendCount = friendCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public String toString() {
        return "SearchAccountDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", accountDescribe='" + accountDescribe + '\'' +
                ", postCount=" + postCount +
                ", friendCount=" + friendCount +
                ", likeCount=" + likeCount +
                '}';
    }
}
