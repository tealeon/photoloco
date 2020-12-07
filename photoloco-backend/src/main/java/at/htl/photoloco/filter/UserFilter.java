package at.htl.photoloco.filter;

import at.htl.photoloco.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.security.Principal;
import java.util.logging.Logger;

@Provider
@ApplicationScoped
public class UserFilter implements ContainerRequestFilter {

    @Context
    SecurityContext securityContext;

    private final Logger LOG = Logger.getLogger(UserFilter.class.getSimpleName());

    @Override
    @Transactional
    public void filter(ContainerRequestContext requestContext) {
        Principal userPrincipal = this.securityContext.getUserPrincipal();

        if (userPrincipal != null) {
            String name = userPrincipal.getName();
            LOG.info("User found with name " + name);
            User user = User.find("username", name).firstResult();

            if (user == null) {
                LOG.info("Persisting User");
                user = new User(name);
                user.persist();
            }
        }
    }
}
