package at.htl.photoloco.control;

import at.htl.photoloco.entity.Location;
import at.htl.photoloco.entity.Photoshoot;
import at.htl.photoloco.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LocationRepository implements PanacheRepository<Location> {

    @Override
    public List<Location> listAll() {
        return findAll().stream().peek(this::init).collect(Collectors.toList());
    }

    private void init(Location location){
        Hibernate.initialize(location);
        Hibernate.initialize(location.getPhotoshoots());
    }

}
