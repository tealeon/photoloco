package at.htl.photoloco.boundary;

import at.htl.photoloco.control.PhotoshootRepository;
import at.htl.photoloco.entity.PhotoShooting;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("photoshoot")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class PhotoshootEndpoint {

    private final Logger LOG = Logger.getLogger(UserEndpoint.class.getSimpleName());

    @Inject
    PhotoshootRepository photoshootRepository;

    @GET
    @Path("all")
    public List<PhotoShooting> getAllPhotoshoot() {
        LOG.info("list all photoshoots");
        return photoshootRepository.listAll();
    }

}
