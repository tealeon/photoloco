package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "RATING")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RTG_ID")
    private Long id;

    @Column(name = "RTG_VALUE")
    private long value;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RTG_POST_ID")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RTG_USR_ID")
    private User user;

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
