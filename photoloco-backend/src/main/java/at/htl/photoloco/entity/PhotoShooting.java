package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PhotoShooting extends PanacheEntity {

    public String title;

    public LocalDate dateOfPhotoShooting;

    @ManyToMany
    public List<User> userInvolved;

    @ManyToOne
    public Location location;

    public PhotoShooting() {
    }
}
