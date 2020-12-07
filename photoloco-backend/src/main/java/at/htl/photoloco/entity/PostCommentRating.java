package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PostCommentRating extends PanacheEntity {

    public boolean isPositive;

    @ManyToOne
    public PostComment postComment;
}
