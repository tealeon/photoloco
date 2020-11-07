package at.htl.photoloco.boundary;

import at.htl.photoloco.entity.Post;
import at.htl.photoloco.entity.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class PostEndpoint {

    @GET
    @Path("/all")
    public List<Post> getAllPosts() {
        return Post.listAll();
    }

    @POST
    @Path("/upload/{userId}")
    public Response create(@PathParam("userId") Long id, Post post){
        User user = User.findById(id);
        user.getPosts().add(post);
        post.setUser(user);
        return Response.ok(user).build();
    }

}
