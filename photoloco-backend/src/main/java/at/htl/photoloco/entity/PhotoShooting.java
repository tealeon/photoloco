package at.htl.photoloco.entity;

import at.htl.photoloco.dto.PhotoShootingDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public PhotoShooting(PhotoShootingDto photoShootingDto) {
        update(photoShootingDto);
    }

    public void update(PhotoShootingDto photoShootingDto) {
        this.title = photoShootingDto.getTitle();
        this.dateOfPhotoShooting = photoShootingDto.getDateOfPhotoShooting();
        this.userInvolved = photoShootingDto.getUserInvolved()
                .stream()
                .map(instagramName -> User.find("instagramName", instagramName).firstResult())
                .map(user -> {
                    User temp = (User) user;
                    temp.photoShootingsInvolvedIn.add(this);
                    return temp;
                })
                .collect(Collectors.toList());
        this.location = Location.find("name", photoShootingDto.getLocation().getName()).firstResult();
    }
}
