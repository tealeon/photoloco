package at.htl.photoloco.boundary;

import at.htl.photoloco.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserEndpoint {

    @POST
    @Path("/insert")
    public Response create(User user){
        user.persist();
        return Response.ok(user).build();
    }

    @GET
    @Path("/all")
    public List<User> getAllUsers() {
        return User.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id) {
        return User.findById(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        User user = User.findById(id);
        if (user.isPersistent()) {
            return Response.ok(User.deleteById(id)).build();
        } else {
            return Response.noContent().build();
        }
    }

    private User getUserFromJson(JsonObject jsonObject) {
        User user = new User();
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
