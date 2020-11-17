package at.htl.photoloco.boundary;

import at.htl.photoloco.control.UserRepository;
import at.htl.photoloco.entity.User;
import org.hibernate.Hibernate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserEndpoint {

    @Inject
    UserRepository userRepository;

    private final Logger LOG = Logger.getLogger(UserEndpoint.class.getSimpleName());

    @POST
    @Path("/insert")
    public Response create(User user){
        userRepository.persist(user);
        user.getPosts().forEach(post -> post.setUser(user));
        LOG.info("user created");
        return Response.ok(user).build();
    }

    @GET
    @Path("/all")
    public List<User> getAllUsers() {
        LOG.info("list all users");
        return userRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") Long id) {
        User user = userRepository.findById(id);
        LOG.info("find user by id " + id);
        return user;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        User user = userRepository.findById(id);
        userRepository.delete(user);
        return Response.ok().build();
    }

    private User getUserFromJson(JsonObject jsonObject) {
        User user = new User();
        user.setUsername(jsonObject.getString("username"));
        user.setFirstName(jsonObject.getString("firstName"));
        user.setLastName(jsonObject.getString("lastName"));
        user.setBiography(jsonObject.getString("biography"));
        user.setCity(jsonObject.getString("city"));
        user.setCountry(jsonObject.getString("country"));
        user.seteMail(jsonObject.getString("eMail"));
        user.setModel(jsonObject.getBoolean("isModel"));
        user.setPhotographer(jsonObject.getBoolean("isPhotographer"));
        return user;
    }
}
