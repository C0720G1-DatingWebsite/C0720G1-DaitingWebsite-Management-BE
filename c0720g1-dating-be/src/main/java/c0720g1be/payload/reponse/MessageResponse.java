package c0720g1be.payload.reponse;

public class MessageResponse {
    /**
     * Nguyen Bao Phuc
     */

    private String message;

    public MessageResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
