package at.htl.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USR")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Long id;

    @Column(name = "USR_FNAME", length = 50)
    private String firstName;

    @Column(name = "USR_LNAME", length = 50)
    private String lastName;

    @Column(name = "USR_EMAIL")
    private String eMail;

    @Column(name = "USR_CITY")
    private String city;

    @Column(name = "USR_COUNTRY")
    private String country;

    @Column(name = "USR_IS_MODEL")
    private boolean isModel;

    @Column(name = "USR_IS_PHOTOGRAPHER")
    private boolean isPhotographer;

    public User() {
    }

    public User(String firstName, String lastName, String eMail, String city,
                String country, boolean isModel, boolean isPhotographer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.city = city;
        this.country = country;
        this.isModel = isModel;
        this.isPhotographer = isPhotographer;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isModel() {
        return isModel;
    }

    public void setModel(boolean model) {
        isModel = model;
    }

    public boolean isPhotographer() {
        return isPhotographer;
    }

    public void setPhotographer(boolean photographer) {
        isPhotographer = photographer;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", isModel=" + isModel +
                ", isPhotograph=" + isPhotographer +
                '}';
    }
}
