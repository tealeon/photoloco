package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.UserDto;
import at.htl.photoloco.dto.UserRatingDto;
import at.htl.photoloco.entity.User;
import at.htl.photoloco.entity.UserRating;
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

    @POST
    @Path("login")
    public Response login(UserDto userDto) {
        User user = User.find("instagramName", userDto.getInstagramName()).firstResult();

        System.out.println(userDto);

        if (user == null) return Response.status(Status.BAD_REQUEST).build();

        if (!user.password.equals(userDto.getPassword())) return Response.status(Status.BAD_REQUEST).build();

        return Response.ok(new UserDto(user)).build();
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
    public List<UserDto> getAllPhotographers() {

        return User.streamAll()
                .map(user -> (User) user)
                .peek(user -> Hibernate.initialize(user.photoShootingsInvolvedIn))
                .filter(user -> user.isPhotographer)
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/models")
    public List<UserDto> getAllModels() {

        return User.streamAll()
                .map(user -> (User) user)
                .filter(user -> user.isModel)
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @POST
    //@Authenticated
    @Transactional
    public Response createUser(@Valid UserDto userDto) {
        System.out.println(userDto);
        User user = new User(userDto);
        user.persist();
        return Response.ok(user).build();
    }

    @GET
    @Path("rating/{instagramName}")
    public Response getRatedUser(@PathParam("instagramName") String instagramName) {
        User user = User.find("instagramName", instagramName).firstResult();
        System.out.println(user.createdRatings);
        List<UserRatingDto> ratings = user.createdRatings
                .stream()
                .map(UserRatingDto::new)
                .collect(Collectors.toList());

        return Response.ok(ratings).build();
    }


    @POST
    @Transactional
    @Path("{instagramName}/{instagramName-rating}")
    public Response rateUser(@PathParam("instagramName") String instagramName, @PathParam("instagramName-rating") String instagramNameRating, Integer rating) {
        User user = User.find("instagramName", instagramName).firstResult();
        User ratedUser = User.find("instagramName", instagramNameRating).firstResult();

        UserRating oldRating = UserRating.find("ratingUser = ?1 and ratedUser = ?2", user, ratedUser).firstResult();
        if (oldRating != null) {
            if (rating == -1) {
                oldRating.delete();
            } else {
                oldRating.rating = rating;
            }
        } else {
            UserRating userRating = new UserRating(ratedUser, user, rating);
            userRating.persist();
        }

        return Response.noContent().build();
    }
}
