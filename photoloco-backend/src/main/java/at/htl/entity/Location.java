package at.htl.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOC_ID")
    private Long id;

    @Column(name = "LOC_NAME")
    private String name;

    @Column(name = "LOC_X_COORD")
    private int xCoord;

    @Column(name = "LOC_Y_COORD")
    private int yCoord;

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
