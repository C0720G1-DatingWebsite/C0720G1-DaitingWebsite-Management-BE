package c0720g1be.payload.request;

public class VerifyRequest {

    private String code;

    public VerifyRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
