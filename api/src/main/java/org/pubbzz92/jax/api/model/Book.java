package org.pubbzz92.jax.api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	
//private variables
	private String id;
	private String author;
	private String name;
	private String price;
	
//getters and setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	} 

}
