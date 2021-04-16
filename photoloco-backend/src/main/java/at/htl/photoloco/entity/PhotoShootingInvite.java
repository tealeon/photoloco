package at.htl.photoloco.entity;

import at.htl.photoloco.dto.PhotoShootingInviteDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
public class PhotoShootingInvite extends PanacheEntity {

    @OneToOne
    public User sender;

    @OneToOne
    public User receiver;

    @OneToOne
    public PhotoShooting photoShooting;

    public PhotoShootingInvite() {
    }

    public PhotoShootingInvite(User sender, User receiver, PhotoShooting photoShooting) {
        this.sender = sender;
        this.receiver = receiver;
        this.photoShooting = photoShooting;
    }

    public PhotoShootingInvite(PhotoShootingInviteDto photoShootingInviteDto) {
        setSender(photoShootingInviteDto.getSender());
        setReceiver(photoShootingInviteDto.getReceiver());
        this.photoShooting = photoShootingInviteDto.getPhotoShooting();
    }

    public void setSender(String sender) {
        this.sender = User.find("instagramName", sender).firstResult();
        //initUser(this.sender);
    }

    public void setReceiver(String receiver) {
        this.receiver = User.find("instagramName", receiver).firstResult();
        //initUser(this.receiver);
    }

   /*
    private void initUser(User user) {
        Hibernate.initialize(user);
        Hibernate.initialize(user.photoShootingsInvolvedIn);
        user.photoShootingsInvolvedIn.stream().peek(shooting -> {
            Hibernate.initialize(shooting.location);
            //shooting.location.photoShootings.stream().peek()
            Hibernate.initialize(shooting.userInvolved);
        });
        Hibernate.initialize(user.posts);
        Hibernate.initialize(user.receivedComments);
        Hibernate.initialize(user.writtenComments);
    }
     */
}
