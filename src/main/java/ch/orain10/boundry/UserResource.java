package ch.orain10.boundry;

import ch.orain10.entity.Todo;
import ch.orain10.entity.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> getUserList() {

        return User.listAll();
    }

    @GET
    @Path("/{id}")
    public User findUserById(@PathParam("id") Long id) {
        return User.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newUser(User user) {
       user.persist();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id) {
        System.out.println(id);
        User.deleteById(id);
        User.flush();
    }
}
