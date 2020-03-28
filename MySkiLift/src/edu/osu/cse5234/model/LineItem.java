package edu.osu.cse5234.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.osu.cse5234.business.view.Item;

@Entity
@Table(name="CUSTOMER_ORDER_LINE_ITEM")

public class LineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="ITEM_ID")
	private int itemID;
	@Column(name="ITEM_NAME")
	String itemName;
	@Transient
	private double price;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<LineItem> items;

	public LineItem(Item inventoryItem) {
		itemName = inventoryItem.getName();
		price = inventoryItem.getUnitPrice();		
	}

	public LineItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	
	
	
}
