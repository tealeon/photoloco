package at.htl.control;

import at.htl.entity.Rating;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RatingRepository implements PanacheRepository<Rating> {
}
