package at.htl.photoloco.dto;

import at.htl.photoloco.entity.Location;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LocationDto {

    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Min(-90)
    @Max(90)
    private Float latitude;

    @NotNull
    @Min(-180)
    @Max(180)
    private Float longitude;

    @NotNull
    @Size(min = 1, max = 255)
    private String description;

    @NotNull
    @Size(min = 1, max = 255)
    private String tag;

    public LocationDto() {
    }

    public LocationDto(Location location) {
        this.id = location.id;
        this.name = location.name;
        this.longitude = location.longitude;
        this.latitude = location.latitude;
        this.description = location.description;
        this.tag = location.tag;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
