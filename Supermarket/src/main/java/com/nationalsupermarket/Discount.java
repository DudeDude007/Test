package com.nationalsupermarket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is responsible for calculating the discounted/total price in the basket
 * @author Rashpal
 *
 */
//TODO Replace the occurrence of item names Apples as enum for strong typing

public class Discount {
	
	
	/**
	 * This method calculates the total amount for each item type 
	 * @param quantity the number of items bought
	 * @param itemType e.g. 'Apple', 'Orange'
	 * @param items list of {@link Item}
	 * @return total discounted value for each item
	 */
	public double getTotalPriceOfEachItem(final Long quantity,final String itemType, final List<Item> items)  {
		double totalPriceOfItem = 0.0;
		
		//TODO refactor this method polymorphism 
		if (itemType.equals("Apple")) {
			double real = quantity/2;
			double halve = quantity % 2;
			
			double priceOfItem = getPrice(items, "Apple");
			
			totalPriceOfItem =  real * priceOfItem +  priceOfItem * halve;
		}
		else if (itemType.equals("Watermelon")) {
			double real = quantity/3;
			double halve = quantity % 3;
			
			double priceOfItem = getPrice(items, "Watermelon");
			
			totalPriceOfItem =  real * priceOfItem *2 +  priceOfItem * halve;
		}
		else {
			double priceOfItem = getPrice(items, "Orange");
			totalPriceOfItem = quantity * priceOfItem;
		}
		
		return totalPriceOfItem;
	}
	
	/**
	 * Calculates the total for the basket, inclusive of the discount
	 * @param items list of items in the basket
	 * @return
	 */
	public double getTotalCalculatedPrice(final List<Item> items) {
		double totalBasketPrice = 0.0;
		
		Map<String, Long> itemNameCount = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

		for (String itemName: itemNameCount.keySet()) {
			Long quantity = itemNameCount.get(itemName);
			totalBasketPrice += getTotalPriceOfEachItem(quantity, itemName, items);
		}
		
		return totalBasketPrice;
	}
	
	/**
	 * Gets price of an item
	 * @param items list of items in the basket
	 * @param name the name of item, such as 'Apple'
	 * @return
	 */
	private double getPrice(final List<Item> items, final String name){
		double price = 0.0;
		
		for (Item item : items) {
			if (item.getName().equals(name)) {
				price = item.getPrice();
				break;
			}
		}
		return price;
	}
}
