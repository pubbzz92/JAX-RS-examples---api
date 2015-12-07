package org.pubbzz92.jax.api.services;

import java.util.ArrayList;
import java.util.List;


import org.pubbzz92.jax.api.database.DatabaseConnections;
import org.pubbzz92.jax.api.model.Book;
import org.pubbzz92.jax.api.utils.AppUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class BookService {
	
	public static DBCollection book = DatabaseConnections.init();
	
	
	//get the list of books
	public List<Book> getBooks(){
		
		List<Book> books =  new ArrayList<Book>();
		try (DBCursor cursor = book.find()) {
		      while (cursor.hasNext()) {
		        DBObject dbObject = cursor.next();
		        books.add((Book) AppUtils.fromDBObject(dbObject, Book.class));
		      }
		    }
		return books;
	}
	
	//get the book with the given id
	public Book getBookById(String id){
		
		  DBObject query = new BasicDBObject("id", id);
		    DBObject dbObject = book.findOne(query);

		    
		      Book book = (Book) AppUtils.fromDBObject(dbObject, Book.class);
		      
		      return book;
		    
	}
	
	//add a new book
	public Book addBook(Book bk){
		long k = book.count() +1;
		bk.setId(String.valueOf(k));
		book.insert(AppUtils.toDBObject(bk));
		return bk;
	}
	
	//delete a book
	public String DeleteBook(String id){
		
		DBObject query = new BasicDBObject("id", id);
	    book.remove(query);
		return id;
	}
	
	//update book details
	public Book updateBook(String id,Book bk){
		DBObject query = new BasicDBObject("id", id);
		DBObject field = new BasicDBObject("$set" ,AppUtils.toDBObject(bk));
		book.update(query, field);
		return bk;
	}
}
