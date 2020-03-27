package edu.osu.cse5234.controller;

//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.util.ConversionUtil;
import edu.osu.cse5234.util.ServiceLocator;

//this is the Purchase controller class

@Controller

// class level request mapping to /purchase
@RequestMapping("/purchase")

public class Purchase {
	// display items for purchase
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// empty order
		Order order = new Order();
		// using util to locate remote service
		InventoryService invServ = ServiceLocator.getInventoryService();
		// remote serv provided , get the avail inventory
		Inventory availableInventory = invServ.getAvailableInventory();
		//order.setItems(availableInventory.getItems());
		// LineItem object for in/out of jsp
		// we must convert
		
		order.setLineItems(ConversionUtil.convert(availableInventory.getItems()));
		
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
