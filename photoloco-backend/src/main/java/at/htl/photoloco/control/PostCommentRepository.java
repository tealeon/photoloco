package at.htl.photoloco.control;

import at.htl.photoloco.entity.PostComment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostCommentRepository implements PanacheRepository<PostComment> {

    private void init(PostComment postComment){
        Hibernate.initialize(postComment);
        Hibernate.initialize(postComment.getReplies());
        Hibernate.initialize(postComment.getUserPostDislikes());
        Hibernate.initialize(postComment.getUserPostLikes());
    }

}
