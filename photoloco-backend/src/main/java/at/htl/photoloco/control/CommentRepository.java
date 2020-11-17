package at.htl.photoloco.control;

import at.htl.photoloco.entity.Comment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommentRepository implements PanacheRepository<Comment> {

    private void init(Comment comment){
        Hibernate.initialize(comment);
        Hibernate.initialize(comment.getRecipient());
        Hibernate.initialize(comment.getAuthor());
    }

}
