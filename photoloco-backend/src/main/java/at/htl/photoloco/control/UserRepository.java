package at.htl.photoloco.control;

import at.htl.photoloco.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    @Override
    public User findById(Long id) {
        User user = find("USR_ID", id).firstResult();

        if (user != null) {
            init(user);
        }

        return user;
    }

    @Override
    public List<User> listAll() {
        return findAll().stream().peek(user -> {
            init(user);
        }).collect(Collectors.toList());
    }

    private void init(User user){
        Hibernate.initialize(user);
        Hibernate.initialize(user.getPosts());
        Hibernate.initialize(user.getUserPhotoshoots());
        Hibernate.initialize(user.getReceivedComments());
        Hibernate.initialize(user.getWrittenComments());
        Hibernate.initialize(user.getUserPostDislikes());
        Hibernate.initialize(user.getUserPostLikes());
    }

}
