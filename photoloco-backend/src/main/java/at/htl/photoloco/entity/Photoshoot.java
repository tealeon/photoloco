package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PHOTOSHOOT")
public class Photoshoot extends PanacheEntity {

    @Column(name = "PHOTOSHT_TITLE")
    public String title;

    @Column(name = "PHOTOSHT_DATE")
    public Date date;

    @OneToMany(mappedBy = "photoshoot", cascade = CascadeType.ALL)
    List<UserPhotoshoot> userPhotoshoots;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PHOTOSHT_LOC_ID")
    public Location location;

    public Photoshoot() {
    }

    public Photoshoot(List<UserPhotoshoot> userPhotoshoots) {
        this.userPhotoshoots = userPhotoshoots;
    }

    public Photoshoot(String title, Date date, Location location) {
        this.title = title;
        this.date = date;
        this.location = location;
    }

    public List<UserPhotoshoot> getAppointments() {
        return userPhotoshoots;
    }

    public void setAppointments(List<UserPhotoshoot> userPhotoshoots) {
        this.userPhotoshoots = userPhotoshoots;
    }

    public Photoshoot(Location location) {
        this.location = location;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Photoshoot{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", appointments=" + userPhotoshoots +
                ", location=" + location +
                '}';
    }
}
