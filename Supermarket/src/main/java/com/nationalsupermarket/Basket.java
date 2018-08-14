package com.nationalsupermarket;

import java.util.ArrayList;
import java.util.List;

import com.nationalsupermarket.exception.ItemDoesNotExistException;

/**
 * This class represents that items that are currently in the shopping basket
 * 
 * @author Rashpal
 *
 */
// TODO Please note logging and audit needs to be carried out in this exercise
public class Basket {
	
	private Stock stock;

	private List<Item> items;
	
	private Discount discount;
	
	public void displayBasket() {
		// TODO
	}

	public Basket() {
		stock =  new Stock();
		items = new ArrayList<Item>();
		discount = new Discount();
	}
	
	public void addItem(String name) throws ItemDoesNotExistException {
		
		// check item is available in this supermarket
		Item item = stock.getItem(name);
		if (item != null) {
			items.add(stock.getItem(name));
		} else {
			throw new ItemDoesNotExistException(String.format("Item name: %s does not exist", name));
		}	
	}
	
	public double getTotal() {
		return discount.getTotalCalculatedPrice(items); 
	}

	public Stock getStock() {
		return stock;
	}
	
}
