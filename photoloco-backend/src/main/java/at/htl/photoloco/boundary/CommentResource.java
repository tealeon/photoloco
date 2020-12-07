package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.PostCommentDto;
import at.htl.photoloco.entity.PostComment;
import io.quarkus.security.Authenticated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("comment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @PUT
    @Path("/{comment-id}")
    @Authenticated
    @Transactional
    public Response updateComment(@PathParam("comment-id") Long commentId, @Valid PostCommentDto updatedPostComment) {
        PostComment postComment = PostComment.findById(commentId);
        if (postComment == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        postComment.update(updatedPostComment);

        return Response.noContent().build();
    }

    @DELETE
    @Path("/{comment-id}")
    @Authenticated
    @Transactional
    public Response updateComment(@PathParam("comment-id") Long commentId) {
        PostComment postComment = PostComment.findById(commentId);
        if (postComment == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        postComment.delete();

        return Response.noContent().build();
    }
}
