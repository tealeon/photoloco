package at.htl.control;

import at.htl.entity.Photoshoot;
import at.htl.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PhotoshootRepository implements PanacheRepository<Photoshoot> {
}
