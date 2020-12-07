package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.UserDto;
import at.htl.photoloco.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {


    @GET
    public Response getAllUsers() {
        List<UserDto> users = User.streamAll().map(user -> (User) user).map(UserDto::new).collect(Collectors.toList());

        return Response.ok(users).build();
    }
}
