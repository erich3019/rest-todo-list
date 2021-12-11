package ch.orain10.boundry;

import ch.orain10.entity.Todo;
import ch.orain10.entity.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    @GET
    public List<Todo> getTodoList() {
        System.out.println(Todo.listAll());
        return Todo.listAll();
    }

    @GET
    @Path("/{id}")
    public Todo findTodoById(@PathParam("id") Long id) {
        return Todo.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response persistTodo(Todo todo) {
        User user = User.findById(todo.user.id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        todo.user = user;
        todo.persist();
        System.out.println(todo.text);
        todo.persist();
        return Response.status(Response.Status.CREATED).entity(todo).build();
    }
}