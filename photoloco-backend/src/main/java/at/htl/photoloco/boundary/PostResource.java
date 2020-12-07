package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.PostCommentDto;
import at.htl.photoloco.dto.PostDto;
import at.htl.photoloco.entity.Post;
import at.htl.photoloco.entity.PostComment;
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

    @DELETE
    @Path("/{post-id}")
    @Authenticated
    @Transactional
    public Response deletePost(@PathParam("post-id") Long postId) {
        Post post = Post.findById(postId);
        if (post == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        post.delete();

        return Response.noContent().build();
    }

    @POST
    @Path("/{post-id}/comment")
    @Authenticated
    @Transactional
    public Response createComment(@PathParam("post-id") Long postId, @Valid PostCommentDto postCommentDto) {
        Post post = Post.findById(postId);
        if (post == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        PostComment postComment = new PostComment(postCommentDto, post, this.securityContext.getUserPrincipal().getName());
        postComment.persist();
        post.comments.add(postComment);

        return Response.noContent().build();
    }

}
