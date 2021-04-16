package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.PhotoShootingInviteDto;
import at.htl.photoloco.entity.PhotoShootingInvite;
import at.htl.photoloco.entity.User;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("invites")
public class InvitationResource {

    @GET
    @Path("/{instagramName}")
    public Response getInvitesOfUser( @PathParam("instagramName") String instagramName) {
        User user = User.find("instagramName", instagramName).firstResult();

        if (user == null) return Response.status(Response.Status.BAD_REQUEST).build();

        List<PhotoShootingInvite> invites = PhotoShootingInvite.find("receiver", user).list();

        return Response.ok(invites).build();
    }

    @GET
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
    public Response sendInviteToUser(PhotoShootingInviteDto photoShootingInviteDto) {
        System.out.println(photoShootingInviteDto.getReceiver());
        PhotoShootingInvite photoShootingInvite = new PhotoShootingInvite(photoShootingInviteDto);
        PhotoShootingInvite.persist(photoShootingInvite);

        return Response.ok(photoShootingInvite).build();
    }
}
