package at.htl.entity;

import javax.persistence.*;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "APPT_USR_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "APPT_PHOTOSHT_ID")
    private Photoshoot photoshoot;

    public Appointment() {
    }

    public Appointment(User user, Photoshoot photoshoot) {
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
