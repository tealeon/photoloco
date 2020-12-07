package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.LocationDto;
import at.htl.photoloco.dto.PostDto;
import at.htl.photoloco.entity.Location;
import at.htl.photoloco.entity.Post;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @GET
    public Response getAllPosts() {
        List<PostDto> posts = Post.streamAll()
                .map(post -> (Post) post)
                .map(PostDto::new)
                .collect(Collectors.toList());

        return Response.ok(posts).build();
    }
}
