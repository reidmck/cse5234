package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

public class Order implements java.io.Serializable{
	
	/**
	 bean, serializable... the order has to be stored in a java bean object; it will have a list of items
	 one full transaction...everything committed to our bean or rolled back.
	 */
	private static final long serialVersionUID = 1L;
	private List<Item> items = new ArrayList<Item>();

	public Order() {}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/*public void addItem(String name, String price, String quantity) {
		Item new skiOrder = new skiOrder(name, price, quantity);
	}
	
	public ArrayList<Item> getSkiOrder() {return skiOrder;}
	public void setSkiOrder(ArrayList<Item> skiOrder) {this.skiOrder = skiOrder;}
	
	public void addSkiOrder(Item newItem) {this.skiOrder.add(newItem);}
	
	//public void addSkiOrder(String string, String string2, String string3) {
		//this.skiOrder.add(newItem);
		
	//}
	 
	 */
}
