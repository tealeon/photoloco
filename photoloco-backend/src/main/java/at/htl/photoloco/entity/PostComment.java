package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "POST_COMMENT")
public class PostComment {

    @Column(name = "POST_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "POST_COMMENT_CONTENT")
    public String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "POST_COMMENT_AUTHOR_ID")
    public User author;

    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    List<UserPostLike> userPostLikes;

    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    List<UserPostDislike> userPostDislikes;

    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    List<PostComment> replies = new LinkedList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "POST_COMMENT_ID")
    public PostComment postComment;

    public PostComment() {
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

    public List<UserPostLike> getUserPostLikes() {
        return userPostLikes;
    }

    public void setUserPostLikes(List<UserPostLike> userPostLikes) {
        this.userPostLikes = userPostLikes;
    }

    public List<UserPostDislike> getUserPostDislikes() {
        return userPostDislikes;
    }

    public void setUserPostDislikes(List<UserPostDislike> userPostDislikes) {
        this.userPostDislikes = userPostDislikes;
    }

    public List<PostComment> getReplies() {
        return replies;
    }

    public void setReplies(List<PostComment> replies) {
        this.replies = replies;
    }

    public PostComment getPostComment() {
        return postComment;
    }

    public void setPostComment(PostComment postComment) {
        this.postComment = postComment;
    }
}
