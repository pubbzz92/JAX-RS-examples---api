package org.pubbzz92.jax.api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.pubbzz92.jax.api.model.Book;
import org.pubbzz92.jax.api.services.BookService;


@Path("/books")
public class BookResource {

	BookService service = new BookService();
	
	// GET api/books
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks(){
		return service.getBooks();
	}
	
	// GET api/books/:id
	@GET
	@Path("/{bookID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookById(@PathParam("bookID") String book_id){
		return service.getBookById(book_id);
	}
	
	// POST api/books
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book addBook(Book book){
		return service.addBook(book);
	}
	
	// PUT api/books/:id
	@PUT
	@Path("/{bookID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book updateBook(@PathParam("bookID") String book_id,Book book){
		return service.updateBook(book_id, book);
	}
	
	// DELETE api/books/:id
	@DELETE
	@Path("/{bookID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteBook(@PathParam("bookID") String book_id){
		return service.DeleteBook(book_id);
	}
}
