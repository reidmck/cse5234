package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.controller.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	public String processOrder(Order order) {
		return null;
	}

	public boolean validateItemAvailability(Order order) {
		return ServiceLocator.getInventoryService().validateQuantity(order.getItems());
	}

}
