package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.PhotoShootingInviteDto;
import at.htl.photoloco.entity.PhotoShootingInvite;
import at.htl.photoloco.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("invites")
@Produces("application/json")
@Consumes("application/json")
public class InvitationResource {

    @GET
    @Path("/{instagramName}")
    public Response getInvitesOfUser(@PathParam("instagramName") String instagramName) {
        User user = User.find("instagramName", instagramName).firstResult();

        if (user == null) return Response.status(Response.Status.BAD_REQUEST).build();

        List<PhotoShootingInviteDto> invites = PhotoShootingInvite
                .stream("receiver.instagramName", instagramName)
                .map(invite -> (PhotoShootingInvite) invite)
                .map(PhotoShootingInviteDto::new)
                .collect(Collectors.toList());

        return Response.ok(invites).build();
    }

    @POST
    @Transactional
    @Path("/{id}/{response}")
    public Response respondToInvite(@PathParam("id") Long id, @PathParam("response") boolean response) {
        PhotoShootingInvite photoShootingInvite = PhotoShootingInvite.findById(id);

        if (photoShootingInvite == null) return Response.status(Response.Status.BAD_REQUEST).build();

        if (response) {
            photoShootingInvite.photoShooting.userInvolved.add(photoShootingInvite.receiver);
        }

        PhotoShootingInvite.deleteById(id);

        return Response.noContent().build();
    }

    @POST
    @Transactional
    @Path("{photoshooting-id}")
    public Response sendInviteToUser(@PathParam("photoshooting-id") Long photoshootingId, PhotoShootingInviteDto photoShootingInviteDto) {
        PhotoShootingInvite photoShootingInvite = new PhotoShootingInvite(photoShootingInviteDto, photoshootingId);
        photoShootingInvite.persist();

        return Response.noContent().build();
    }
}
