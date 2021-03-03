package c0720g1be.dto;

public class CreatePostDTO {
    Integer idAccount;
    Integer idPolicy;
    String contentPost;
    String imagePost;

    public CreatePostDTO() {
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Integer getIdPolicy() {
        return idPolicy;
    }

    public void setIdPolicy(Integer idPolicy) {
        this.idPolicy = idPolicy;
    }

    public String getContentPost() {
        return contentPost;
    }

    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }

    public String getImagePost() {
        return imagePost;
    }

    public void setImagePost(String imagePost) {
        this.imagePost = imagePost;
    }
}
