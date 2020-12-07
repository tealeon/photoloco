package at.htl.photoloco.dto;

import at.htl.photoloco.entity.Location;
import at.htl.photoloco.entity.PhotoShooting;

import java.time.LocalDate;

public class PhotoShootingDto {

    private Long id;

    private String title;

    private LocalDate dateOfPhotoShooting;

    private LocationDto location;

    public PhotoShootingDto() {
    }

    public PhotoShootingDto(PhotoShooting photoShooting) {
        this.id = photoShooting.id;
        this.title = photoShooting.title;
        this.dateOfPhotoShooting = photoShooting.dateOfPhotoShooting;
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
}
