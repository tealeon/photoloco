package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.UserDto;
import at.htl.photoloco.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
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

    @GET
    @Path("/{user-id}")
    public Response getUserById(@PathParam("user-id") Long userId) {
        User user = User.findById(userId);
        if (user == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(new UserDto(user)).build();
    }
}
