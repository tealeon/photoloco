package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserRating extends PanacheEntity {

    @ManyToOne
    public User ratedUser;

    @ManyToOne
    public User ratingUser;

    public Integer rating;

    public UserRating() {
    }

    public UserRating(User ratedUser, User ratingUser, Integer rating) {
        this.ratedUser = ratedUser;
        this.ratingUser = ratingUser;
        this.rating = rating;
    }
}
