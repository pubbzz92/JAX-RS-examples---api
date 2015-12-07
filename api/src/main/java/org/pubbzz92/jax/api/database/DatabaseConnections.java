package org.pubbzz92.jax.api.database;

import java.net.UnknownHostException;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DatabaseConnections {
	
	//private static Map<Long, Book> book = new HashMap<>();
	private static MongoClient mongo;
	private static DB db;
	private static DBCollection collection;
	
	
	public static DBCollection init() {
		// TODO Auto-generated method stub
		try{
			mongo = new MongoClient("localhost",27017);
			db=mongo.getDB("bookshelf");
			collection=db.getCollection("books");
			
			
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		return collection;
	}



//	public static Map<Long, Book> getBook() {
//		return book;
//	}

	
}
