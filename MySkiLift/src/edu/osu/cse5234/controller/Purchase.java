package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//this is the Purchase controller class

@Controller

// class level request mapping to /purchase
@RequestMapping("/purchase")

public class Purchase {
	// display items for purchase
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display

		Order order = new Order();
		List<Item> items = new java.util.ArrayList<Item>();

		Item item1 = new Item();
		item1.setName("Atomic Nomad Blackeye Skis");
		item1.setPrice("655");
		items.add(item1);

		Item item2 = new Item();
		item2.setName("K2 Luv-IT 76 Skis");
		item2.setPrice("350");
		items.add(item2);

		Item item3 = new Item();
		item3.setName("Volkl XTD Skis");
		item3.setPrice("255");
		items.add(item3);

		Item item4 = new Item();
		item4.setName("Rossingnol Smash 7 Skis");
		item4.setPrice("298");
		items.add(item4);

		Item item5 = new Item();
		item5.setName("Atomic Affinity Storm Skis");
		item5.setPrice("425");
		items.add(item5);

		// Item item = new Item();
		// List<Item> myItems = liftTicketOrder.getItems();

		order.setItems(items);

		//request.setAttribute("order", liftTicketOrder);
		request.setAttribute("order", order);
		// return the name of the jsp form
		return "OrderEntryForm";
	}
	// submit selected items for purchase, then redirect to paymentEntryForm.jsp

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {

		request.getSession().setAttribute("order", order);

		return "redirect:/purchase/paymentEntry";
	}

	// display payment entry form

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());
		return "PaymentEntryForm";
	}

	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		return "redirect:/purchase/shippingEntry";
	}

	// display shipping info, validate and store shipping info

	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm";
	}

	// submit shipping info, redirect to view order

	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo,
			HttpServletRequest request) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}

	// display complete order

	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ViewOrder";
	}

	// confirm order

	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/viewConfirmation";
	}

	// display confirmation

	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Confirmation";
	}
	
}
