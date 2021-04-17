package at.htl.photoloco.dto;

import at.htl.photoloco.entity.UserRating;

public class UserRatingDto {

    private String user;
    private Integer rating;

    public UserRatingDto(UserRating userRating) {
        this.user = userRating.ratedUser.instagramName;
        this.rating = userRating.rating;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
