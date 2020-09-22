package at.htl.control;

import at.htl.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public void deleteByName(String name) {
        delete("name", name);
    }

    public User findByName(String name) {
        return find("name", name).firstResult();
    }

}
