package edu.osu.cse5234.controller;
// this is the Item model class

//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Item implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String price;
	private String quantity;
	 
	//public Item() { }
	public String 	getName() {return name;}
	public String 	getPrice() {return price;}
	public String 	getQuantity() {return quantity;}
	public void 	setName(String name) {this.name = name;}
	public void 	setPrice(String price) {this.price = price;}
	public void 	setQuantity(String quantity) {this.quantity = quantity;}
}
