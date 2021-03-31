package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.PostCommentDto;
import at.htl.photoloco.dto.PostDto;
import at.htl.photoloco.dto.UserDto;
import at.htl.photoloco.entity.Post;
import at.htl.photoloco.entity.PostComment;
import at.htl.photoloco.entity.User;
import io.quarkus.security.Authenticated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;
import java.util.stream.Collectors;


@Path("postcomment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostCommentResource {

    @Context
    SecurityContext securityContext;

    @GET
    public Response getAllPostComments() {
        List<PostCommentDto> comments = PostComment.streamAll()
                .map(comment -> (PostComment) comment)
                .map(PostCommentDto::new)
                .collect(Collectors.toList());

        return Response.ok(comments).build();
    }

    @GET
    @Path("/{post-id}")
    public List<PostComment> getCommentsByPostId(@PathParam("post-id") Long id) {
        Post post = Post.find("id", id).firstResult();

        return post.comments;
    }



}
