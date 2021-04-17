package at.htl.photoloco.entity;

import at.htl.photoloco.dto.PhotoShootingInviteDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PhotoShootingInvite extends PanacheEntity {

    @ManyToOne
    public User sender;

    @ManyToOne
    public User receiver;

    @ManyToOne
    public PhotoShooting photoShooting;

    public PhotoShootingInvite() {
    }

    public PhotoShootingInvite(PhotoShootingInviteDto photoShootingInviteDto, Long photoshootingId) {
        this.sender = User.find("instagramName", photoShootingInviteDto.getSender()).firstResult();
        this.receiver = User.find("instagramName", photoShootingInviteDto.getReceiver()).firstResult();
        this.photoShooting = PhotoShooting.findById(photoshootingId);
    }
}
