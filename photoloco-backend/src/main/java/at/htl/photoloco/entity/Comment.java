package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends PanacheEntity {

    public String content;

    public Rating rating;

    @ManyToOne
    public User author;

    @ManyToOne
    public User recipient;

    public Comment() {
    }
}
