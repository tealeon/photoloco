package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "USR")
public class User extends PanacheEntity {

    @Column(name = "USR_NAME", length = 50, unique = true)
    public String username;

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
    List<UserPhotoshoot> userPhotoshoots = new LinkedList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Post> posts = new LinkedList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Comment> writtenComments = new LinkedList<>();

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    List<Comment> receivedComments = new LinkedList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserPostLike> userPostLikes = new LinkedList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserPostDislike> userPostDislikes = new LinkedList<>();

    public User() {
    }

    public User(String username, String firstName, String lastName, String eMail, String city, String country, boolean isModel, boolean isPhotographer, String biography) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.city = city;
        this.country = country;
        this.isModel = isModel;
        this.isPhotographer = isPhotographer;
        this.biography = biography;
    }

    public List<UserPhotoshoot> getUserPhotoshoots() {
        return userPhotoshoots;
    }

    public void setUserPhotoshoots(List<UserPhotoshoot> userPhotoshoots) {
        this.userPhotoshoots = userPhotoshoots;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
