package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "_user")
public class User extends PanacheEntity {

    public String username;

    public String firstName;

    public String lastName;

    public String email;

    public String imageUrl;

    public String city;

    public String country;

    public boolean isModel;

    public boolean isPhotographer;

    public String biography;

    public String instagramName;

    public String websiteUrl;

    @ManyToMany
    public List<PhotoShooting> photoShootingsInvolvedIn = new LinkedList<>();

    @OneToMany(mappedBy = "author")
    public List<Post> posts = new LinkedList<>();

    @OneToMany(mappedBy = "author")
    public List<Comment> writtenComments = new LinkedList<>();

    @OneToMany(mappedBy = "recipient")
    public List<Comment> receivedComments = new LinkedList<>();

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
