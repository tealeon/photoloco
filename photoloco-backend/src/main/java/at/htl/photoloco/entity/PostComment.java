package at.htl.photoloco.entity;

import at.htl.photoloco.dto.PostCommentDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class PostComment extends PanacheEntity {

    public String content;

    @ManyToOne
    public User author;

    @ManyToOne
    public PostComment postRepliedTo;

    @ManyToOne
    public Post post;

    @OneToMany(mappedBy = "postRepliedTo")
    public List<PostComment> replies = new LinkedList<>();

    @OneToMany
    public List<PostCommentRating> ratings = new LinkedList<>();

    public PostComment() {
    }

    public PostComment(PostCommentDto postCommentDto, Post post, String username) {
        this.content = postCommentDto.getContent();
        this.author = User.find("username", username).firstResult();
        this.post = post;
    }

    public void update(PostCommentDto updatedPostComment) {
        this.content = updatedPostComment.getContent();
    }
}
