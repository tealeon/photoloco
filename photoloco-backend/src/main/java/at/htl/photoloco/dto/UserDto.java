package at.htl.photoloco.dto;

import at.htl.photoloco.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String imageUrl;

    private String city;

    private String country;

    private boolean isModel;

    private boolean isPhotographer;

    private String instagramName;

    private String websiteUrl;

    private List<PhotoShootingDto> photoShootingsInvolvedIn = new LinkedList<>();

    public UserDto() {
    }

    public UserDto(User user) {
        this.username = user.username;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.imageUrl = user.imageUrl;
        this.city = user.city;
        this.country = user.country;
        this.isModel = user.isModel;
        this.isPhotographer = user.isPhotographer;
        this.instagramName = user.instagramName;
        this.websiteUrl = user.websiteUrl;
        this.photoShootingsInvolvedIn = user.photoShootingsInvolvedIn.stream().map(PhotoShootingDto::new).collect(Collectors.toList());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getInstagramName() {
        return instagramName;
    }

    public void setInstagramName(String instagramName) {
        this.instagramName = instagramName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<PhotoShootingDto> getPhotoShootingsInvolvedIn() {
        return photoShootingsInvolvedIn;
    }

    public void setPhotoShootingsInvolvedIn(List<PhotoShootingDto> photoShootingsInvolvedIn) {
        this.photoShootingsInvolvedIn = photoShootingsInvolvedIn;
    }
}
