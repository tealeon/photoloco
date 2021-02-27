package at.htl.photoloco.dto;

import at.htl.photoloco.entity.PhotoShooting;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PhotoShootingDto {

    private Long id;

    private String title;

    private LocalDate dateOfPhotoShooting;

    public List<String> userInvolved;

    private LocationDto location;

    public PhotoShootingDto() {
    }

    public PhotoShootingDto(PhotoShooting photoShooting) {
        this.id = photoShooting.id;
        this.title = photoShooting.title;
        this.dateOfPhotoShooting = photoShooting.dateOfPhotoShooting;
        this.userInvolved = photoShooting.userInvolved.stream().map(user -> user.instagramName).collect(Collectors.toList());
        this.location = new LocationDto(photoShooting.location);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfPhotoShooting() {
        return dateOfPhotoShooting;
    }

    public void setDateOfPhotoShooting(LocalDate dateOfPhotoShooting) {
        this.dateOfPhotoShooting = dateOfPhotoShooting;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public List<String> getUserInvolved() {
        return userInvolved;
    }

    public void setUserInvolved(List<String> userInvolved) {
        this.userInvolved = userInvolved;
    }
}
