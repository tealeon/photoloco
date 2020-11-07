package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USR")
public class User extends PanacheEntity{

    @Column(name = "USR_FNAME", length = 50)
    public String firstName;

    @Column(name = "USR_LNAME", length = 50)
    public String lastName;

    @Column(name = "USR_EMAIL")
    public String eMail;

    @Column(name = "USR_CITY")
    public String city;

    @Column(name = "USR_COUNTRY")
    public String country;

    @Column(name = "USR_IS_MODEL")
    public boolean isModel;

    @Column(name = "USR_IS_PHOTOGRAPHER")
    public boolean isPhotographer;

    @Column(name = "USR_BIOGRAPHY")
    public String biography;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserPhotoshoot> userPhotoshoots;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Rating> ratings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Post> posts;

    public User() {
    }

    public User(List<UserPhotoshoot> userPhotoshoots, List<Rating> ratings, List<Post> posts) {
        this.userPhotoshoots = userPhotoshoots;
        this.ratings = ratings;
        this.posts = posts;
    }

    public User(String firstName, String lastName, String eMail, String city,
                String country, boolean isModel, boolean isPhotographer, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.city = city;
        this.country = country;
        this.isModel = isModel;
        this.isPhotographer = isPhotographer;
        this.biography = biography;
    }

    public List<UserPhotoshoot> getAppointments() {
        return userPhotoshoots;
    }

    public void setAppointments(List<UserPhotoshoot> userPhotoshoots) {
        this.userPhotoshoots = userPhotoshoots;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

}
