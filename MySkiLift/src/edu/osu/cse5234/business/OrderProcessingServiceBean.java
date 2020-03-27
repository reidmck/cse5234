package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.controller.Order;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	@PersistenceContext	EntityManager entityManager;
	public String processOrder(Order order) {
		entityManager.persist(order);
		entityManager.flush();
		return null;
	}

	public boolean validateItemAvailability(Order order) {
		return true;
		//return ServiceLocator.getInventoryService().validateQuantity(order.getItems());
	}

}
