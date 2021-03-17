package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.PostCommentDto;
import at.htl.photoloco.entity.PostComment;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
