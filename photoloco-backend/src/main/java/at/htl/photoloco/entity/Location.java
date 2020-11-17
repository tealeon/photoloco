package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOCATION")
public class Location {

    @Column(name = "LOC_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "LOC_NAME")
    public String name;

    @Column(name = "LOC_X_COORD")
    public int xCoord;

    @Column(name = "LOC_Y_COORD")
    public int yCoord;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    List<Photoshoot> photoshoots;

    public Location() {
    }

    public Location(List<Photoshoot> photoshoots) {
        this.photoshoots = photoshoots;
    }

    public Location(String name, int xCoord, int yCoord) {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public List<Photoshoot> getPhotoshoots() {
        return photoshoots;
    }

    public void setPhotoshoots(List<Photoshoot> photoshoots) {
        this.photoshoots = photoshoots;
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

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", photoshoots=" + photoshoots +
                '}';
    }
}
