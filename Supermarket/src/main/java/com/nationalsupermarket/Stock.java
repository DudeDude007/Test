package com.nationalsupermarket;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the current stock/inventory that the items the supermarket stocks
 * @author Rashpal
 *
 */
public class Stock {
	
	private List<Item> stockedItems;
	
	public Stock() {
		stockedItems =  new ArrayList<Item>();
	}
	
	/**
	 * Adds items into stock
	 * @param item Item
	 */
	public void addItem(Item item) {
		stockedItems.add(item);
	}
	
	/**
	 * This method gets the Item for a particular item name
	 * @param name name of the item, e.g. 'Apple'
	 * @return {@link Item} if item found null otherwise
	 */
	public Item getItem(final String name) {
		Item result = null;
		
		for (Item item : stockedItems) {
			if (item.getName().equals(name)) {
				result = item;
				break;
			}
		}
		
		return result;
	}
}
