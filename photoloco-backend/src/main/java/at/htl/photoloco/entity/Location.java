package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Location extends PanacheEntity {

    public String name;

    public float longitude;

    public float latitude;

    @OneToMany(mappedBy = "location")
    public List<PhotoShooting> photoShootings;

    public Location() {
    }
}
