package at.htl.photoloco.boundary;

import at.htl.photoloco.control.PostRepository;
import at.htl.photoloco.control.UserRepository;
import at.htl.photoloco.entity.Post;
import at.htl.photoloco.entity.User;
import org.hibernate.Hibernate;

import javax.inject.Inject;
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

    @Inject
    UserRepository userRepository;

    @Inject
    PostRepository postRepository;

    @GET
    @Path("/all")
    public List<Post> getAllPosts() {
        return postRepository.listAll();
    }

    @POST
    @Path("/upload/{userId}")
    public Response create(@PathParam("userId") Long id, Post post){
        User user = userRepository.findById(id);
        user.getPosts().add(post);
        post.setUser(user);
        return Response.ok(user).build();
    }

}
