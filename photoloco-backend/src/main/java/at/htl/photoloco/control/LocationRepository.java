package at.htl.photoloco.control;

import at.htl.photoloco.entity.Location;
import at.htl.photoloco.entity.Photoshoot;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LocationRepository implements PanacheRepository<Location> {

    private void init(Location location){
        Hibernate.initialize(location);
        Hibernate.initialize(location.getPhotoshoots());
    }

}
