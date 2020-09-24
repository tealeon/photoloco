package at.htl.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PHOTOSHOOT")
public class Photoshoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHOTOSHT_ID")
    private Long id;

    @Column(name = "PHOTOSHT_TITLE")
    private String title;

    @Column(name = "PHOTOSHT_DATE")
    private Date date;

    @OneToMany(mappedBy = "photoshoot", cascade = CascadeType.ALL)
    List<Appointment> appointments;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PHOTOSHT_LOC_ID")
    private Location location;

    public Photoshoot() {
    }

    public Photoshoot(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Photoshoot(String title, Date date, Location location) {
        this.title = title;
        this.date = date;
        this.location = location;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
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
                ", appointments=" + appointments +
                ", location=" + location +
                '}';
    }
}
