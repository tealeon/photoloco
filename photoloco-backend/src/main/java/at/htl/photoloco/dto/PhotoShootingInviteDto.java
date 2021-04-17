package at.htl.photoloco.dto;

public class PhotoShootingInviteDto {

    private String sender;
    private String receiver;

    public PhotoShootingInviteDto() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
