package at.htl.photoloco.control;

import at.htl.photoloco.entity.Comment;
import at.htl.photoloco.entity.Photoshoot;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PhotoshootRepository implements PanacheRepository<Photoshoot> {

    private void init(Photoshoot photoshoot){
        Hibernate.initialize(photoshoot);
        Hibernate.initialize(photoshoot.getUserPhotoshoots());
    }

}
