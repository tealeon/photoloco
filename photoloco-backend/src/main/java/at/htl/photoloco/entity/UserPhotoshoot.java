package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class UserPhotoshoot {

    @Column(name = "USR_PHOTOSHT_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USR_ID")
    public User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PHOTOSHT_ID")
    public Photoshoot photoshoot;

    public UserPhotoshoot() {
    }

    public UserPhotoshoot(User user, Photoshoot photoshoot) {
        this.user = user;
        this.photoshoot = photoshoot;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Photoshoot getPhotoshoot() {
        return photoshoot;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", user=" + user +
                ", photoshoot=" + photoshoot +
                '}';
    }
}
