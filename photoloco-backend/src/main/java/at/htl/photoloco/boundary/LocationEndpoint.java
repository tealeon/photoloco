package at.htl.photoloco.boundary;

import at.htl.photoloco.control.LocationRepository;
import at.htl.photoloco.entity.Location;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("location")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class LocationEndpoint {

    @Inject
    LocationRepository locationRepository;

    private final Logger LOG = Logger.getLogger(LocationEndpoint.class.getSimpleName());

    @GET
    @Path("/all")
    public List<Location> getAllLocations() {
        LOG.info("list all photographers");
        return locationRepository.listAll();
    }

}
