package at.htl.photoloco.entity;

import at.htl.photoloco.dto.LocationDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location extends PanacheEntity {

    public String name;

    public Float longitude;

    public Float latitude;

    public String description;

    public String tag;

    @OneToMany(mappedBy = "location")
    public List<PhotoShooting> photoShootings;

    public Location() {
    }

    public Location(LocationDto locationDto) {
        this.name = locationDto.getName();
        this.longitude = locationDto.getLongitude();
        this.latitude = locationDto.getLatitude();
        this.description = locationDto.getDescription();
        this.tag = locationDto.getTag();
    }

    public void update(LocationDto updatedLocation) {
        this.name = updatedLocation.getName();
        this.longitude = updatedLocation.getLongitude();
        this.latitude = updatedLocation.getLatitude();
        this.description = updatedLocation.getDescription();
        this.tag = updatedLocation.getTag();
    }
}
