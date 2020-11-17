package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
public class Comment {

    @Column(name = "COMMENT_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public enum RATING {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

        private final int value;

        RATING(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }
    }

    @Column(name = "COMMENT_CONTENT")
    public String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "WRITTEN_COMMENT_USR_ID")
    public User author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RECEIVED_COMMENT_USR_ID")
    public User recipient;


    @Column(name = "COMMENT_RATING")
    public RATING rating;

    public Comment() {
    }

    public Comment(String content, User author, User recipient, RATING rating) {
        this.content = content;
        this.author = author;
        this.recipient = recipient;
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public RATING getRating() {
        return rating;
    }

    public void setRating(RATING rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", author=" + author +
                ", recipient=" + recipient +
                ", rating=" + rating +
                '}';
    }
}
