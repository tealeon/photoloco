package at.htl.control;

import at.htl.entity.Location;
import at.htl.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LocationRepository implements PanacheRepository<Location> {
}
