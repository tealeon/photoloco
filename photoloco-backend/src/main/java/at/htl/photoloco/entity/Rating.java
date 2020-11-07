package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "RATING")
public class Rating extends PanacheEntity {

    @Column(name = "RTG_VALUE")
    public long value;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RTG_POST_ID")
    public Post post;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RTG_USR_ID")
    public User user;

    public Rating() {
    }

    public Rating(long value, Post post) {
        this.value = value;
        this.post = post;
    }

    public Rating(long value, User user) {
        this.value = value;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", value=" + value +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
