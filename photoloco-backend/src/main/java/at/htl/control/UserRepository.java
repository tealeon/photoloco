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

    public User update(User user, Long id) {
        User u = findById(id);
        if(u != null){
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.seteMail(user.geteMail());
            u.setCountry(user.getCountry());
            u.setCity(user.getCity());
            u.setBiography(user.getBiography());
            u.setModel(user.isModel());
            u.setPhotographer(user.isPhotographer());
            return u;
        } else return null;
    }

}
