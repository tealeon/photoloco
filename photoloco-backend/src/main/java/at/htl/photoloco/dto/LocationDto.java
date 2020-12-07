package at.htl.photoloco.dto;

import at.htl.photoloco.entity.Location;

public class LocationDto {

    private Long id;

    private float longitude;

    private float latitude;

    public LocationDto() {
    }

    public LocationDto(Location location) {
        this.id = location.id;
        this.longitude = location.longitude;
        this.latitude = location.latitude;
    }

    public Long getId() {
        return id;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
