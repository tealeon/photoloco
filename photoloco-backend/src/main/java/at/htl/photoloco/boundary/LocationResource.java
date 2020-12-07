package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.LocationDto;
import at.htl.photoloco.dto.UserDto;
import at.htl.photoloco.entity.Location;
import at.htl.photoloco.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;
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
}
