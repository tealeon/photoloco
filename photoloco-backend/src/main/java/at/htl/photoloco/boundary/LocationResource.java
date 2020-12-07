package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.LocationDto;
import at.htl.photoloco.entity.Location;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("location")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationResource {

    @GET
    public Response getAllLocations() {
        List<LocationDto> locations = Location.streamAll()
                .map(location -> (Location) location)
                .map(LocationDto::new)
                .collect(Collectors.toList());

        return Response.ok(locations).build();
    }

    @POST
    @Transactional
    public Response createLocation(@Valid LocationDto locationDto) {
        Location location = new Location(locationDto);
        location.persist();

        return  Response.noContent().build();
    }
}
