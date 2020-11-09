package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "POST_COMMENT")
public class PostComment extends PanacheEntity {

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
}
