package at.htl.photoloco.entity;

import at.htl.photoloco.dto.UserDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public String password;

    @ManyToMany(mappedBy = "userInvolved")
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

    public User(UserDto userDto){
        this.username = userDto.getUsername();
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.imageUrl = userDto.getImageUrl();
        this.city = userDto.getCity();
        this.country = userDto.getCountry();
        this.isModel = userDto.isModel();
        this.isPhotographer = userDto.isPhotographer();
        this.biography = userDto.getBiography();
        this.instagramName = userDto.getInstagramName();
        this.websiteUrl = userDto.getWebsiteUrl();
        this.photoShootingsInvolvedIn = userDto.getPhotoShootingsInvolvedIn()
                .stream()
                .map(PhotoShooting::new)
                .collect(Collectors.toList());
        //this.posts = userDto.getPosts
        //this.writtenComments = writtenComments;
        //this.receivedComments = receivedComments;
    }


    /*
    public PhotoShooting(PhotoShootingDto photoShootingDto) {
        update(photoShootingDto);
    }

    public void update(PhotoShootingDto photoShootingDto) {
        this.userInvolved = photoShootingDto.getUserInvolved()
                .stream()
                .map(instagramName -> User.find("instagramName", instagramName).firstResult())
                .map(user -> {
                    User temp = (User) user;
                    temp.photoShootingsInvolvedIn.add(this);
                    return temp;
                })
                .collect(Collectors.toList());
        this.location = Location.find("name", photoShootingDto.getLocation().getName()).firstResult();
    }
     */

    //Konstruktor wird diese Fun aufrufen
    public void update(UserDto updatedUser) {

    }
}
