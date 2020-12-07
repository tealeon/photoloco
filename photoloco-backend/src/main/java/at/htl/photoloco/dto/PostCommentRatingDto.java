package at.htl.photoloco.dto;

import at.htl.photoloco.entity.PostCommentRating;

public class PostCommentRatingDto {

    private Long id;

    private Boolean isPositive;

    public PostCommentRatingDto(PostCommentRating postCommentRating) {
        this.id = postCommentRating.id;
        this.isPositive = postCommentRating.isPositive;
    }

    public Long getId() {
        return id;
    }

    public Boolean getPositive() {
        return isPositive;
    }

    public void setPositive(Boolean positive) {
        isPositive = positive;
    }
}
