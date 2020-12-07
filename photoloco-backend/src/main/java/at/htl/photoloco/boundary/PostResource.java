package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.PostDto;
import at.htl.photoloco.entity.Post;
import io.quarkus.security.Authenticated;

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

@Path("post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @Context
    SecurityContext securityContext;

    @GET
    public Response getAllPosts() {
        List<PostDto> posts = Post.streamAll()
                .map(post -> (Post) post)
                .map(PostDto::new)
                .collect(Collectors.toList());

        return Response.ok(posts).build();
    }

    @POST
    @Authenticated
    @Transactional
    public Response createPost(@Valid PostDto postDto) {
        Post post = new Post(postDto, this.securityContext.getUserPrincipal().getName());
        post.persist();

        return Response.noContent().build();
    }

    @PUT
    @Path("/{post-id}")
    @Authenticated
    @Transactional
    public Response createPost(@PathParam("post-id") Long id, @Valid PostDto updatedPost) {
        Post post = Post.findById(id);
        if (post == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        post.update(updatedPost);

        return Response.noContent().build();
    }
}
