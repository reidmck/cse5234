package edu.osu.cse5234.util;

import java.util.ArrayList;
import java.util.List;

import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;

public class ConversionUtil {

	public static List<LineItem> convert(List<Item> items) {
		// TODO Auto-generated method stub
		List<LineItem> lineItems = new ArrayList<LineItem>();
		for (Item item : items) {
			LineItem lineItem = new LineItem(item);
			lineItems.add(lineItem);
		}
		return lineItems;
	}

}
