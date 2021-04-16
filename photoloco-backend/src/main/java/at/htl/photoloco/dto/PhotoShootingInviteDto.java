package at.htl.photoloco.dto;

import at.htl.photoloco.entity.PhotoShooting;
import at.htl.photoloco.entity.PhotoShootingInvite;
import at.htl.photoloco.entity.User;

public class PhotoShootingInviteDto {

    private String sender;
    private String receiver;
    private PhotoShooting photoShooting;

    public PhotoShootingInviteDto() {
    }

    public PhotoShootingInviteDto(String sender, String receiver, PhotoShooting photoShooting) {
        this.sender = sender;
        this.receiver = receiver;
        this.photoShooting = photoShooting;
    }

    public PhotoShootingInviteDto(PhotoShootingInvite photoShootingInvite) {
        this.sender = photoShootingInvite.sender.instagramName;
        this.receiver = photoShootingInvite.receiver.instagramName;
        this.photoShooting = photoShootingInvite.photoShooting;
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

    public PhotoShooting getPhotoShooting() {
        return photoShooting;
    }

    public void setPhotoShooting(PhotoShooting photoShooting) {
        this.photoShooting = photoShooting;
    }
}
