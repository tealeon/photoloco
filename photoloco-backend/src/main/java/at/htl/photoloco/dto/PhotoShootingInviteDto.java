package at.htl.photoloco.dto;

import at.htl.photoloco.entity.PhotoShootingInvite;

import java.time.LocalDate;

public class PhotoShootingInviteDto {

    private Long id;
    private String sender;
    private String receiver;
    private LocalDate dateOfPhotoShooting;
    private String location;
    private String title;

    public PhotoShootingInviteDto() {
    }

    public PhotoShootingInviteDto(PhotoShootingInvite invite) {
        this.id = invite.id;
        this.sender = invite.sender.instagramName;
        this.receiver = invite.receiver.instagramName;
        this.dateOfPhotoShooting = invite.photoShooting.dateOfPhotoShooting;
        this.location = invite.photoShooting.location.name;
        this.title = invite.photoShooting.title;
    }

    public Long getId() {
        return id;
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

    public LocalDate getDateOfPhotoShooting() {
        return dateOfPhotoShooting;
    }

    public void setDateOfPhotoShooting(LocalDate dateOfPhotoShooting) {
        this.dateOfPhotoShooting = dateOfPhotoShooting;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
