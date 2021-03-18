package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.UserDto;
import at.htl.photoloco.entity.User;
import io.quarkus.security.Authenticated;
import org.hibernate.Hibernate;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import java.util.List;
import java.util.stream.Collectors;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Context
    SecurityContext securityContext;

    @GET
    public Response getAllUsers() {
        List<UserDto> users = User.streamAll().map(user -> (User) user).map(UserDto::new).collect(Collectors.toList());

        return Response.ok(users).build();
    }

    @PUT
    @Authenticated
    @Transactional
    public Response updateUser(@Valid UserDto updatedUser) {
        String name = this.securityContext.getUserPrincipal().getName();
        User user = User.find("username", name).firstResult();
        user.update(updatedUser);

        return Response.noContent().build();
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

    @GET
    @Path("/insta/{instagram-name}")
    public Response getUserByInstagramName(@PathParam("instagram-name") String instagramName) {
        User user = User.find("instagramName", instagramName).firstResult();

        if (user == null) return Response.status(Status.BAD_REQUEST).build();

        return Response.ok(new UserDto(user)).build();
    }

    @GET
    @Path("/photographers")
    public List<UserDto> getAllPhotographers(){

        return User.streamAll()
                .map(user -> (User) user)
                .peek(user -> Hibernate.initialize(user.photoShootingsInvolvedIn))
                .filter(user -> user.isPhotographer)
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/models")
    public List<UserDto> getAllModels(){

        return User.streamAll()
                .map(user -> (User) user)
                .filter(user -> user.isModel)
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    /*
    @POST
    //@Authenticated
    @Transactional
    public Response createUser(@Valid UserDto userDto) {
        User user = new User(userDto);
        user.persist();
        return Response.noContent().build();
    }
    */
}
