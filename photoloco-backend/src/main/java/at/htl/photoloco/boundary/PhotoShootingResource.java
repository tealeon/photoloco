package at.htl.photoloco.boundary;

import at.htl.photoloco.dto.PhotoShootingDto;
import at.htl.photoloco.entity.PhotoShooting;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("photoshootings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PhotoShootingResource {

    @GET
    public Response getAllPhotoShootings() {
        List<PhotoShootingDto> photoShootings = PhotoShooting.streamAll()
                .map(photoshooting -> (PhotoShooting) photoshooting)
                .map(PhotoShootingDto::new)
                .collect(Collectors.toList());
        return Response.ok(photoShootings).build();
    }

    @POST
    @Transactional
    public Response createPhotoshooting(@Valid PhotoShootingDto photoShootingDto) {
        PhotoShooting photoShooting = new PhotoShooting(photoShootingDto);
        photoShooting.persist();

        return Response.noContent().build();
    }

    @PUT
    @Transactional
    @Path("/{photoshooting-id}")
    public Response updatePhotoshooting(@PathParam("photoshooting-id") Long id, @Valid PhotoShootingDto updatedPhotoshooting){
        PhotoShooting photoShooting = PhotoShooting.findById(id);

        if(photoShooting == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        photoShooting.update(updatedPhotoshooting);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{photoshooting-id}")
    public Response deletePhotoshooting(@PathParam("photoshooting-id") Long id, @Valid PhotoShootingDto updatedPhotoshooting){
        PhotoShooting photoShooting = PhotoShooting.findById(id);

        if(photoShooting == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        photoShooting.delete();
        return Response.noContent().build();
    }

}
