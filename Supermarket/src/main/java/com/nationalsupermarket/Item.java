package com.nationalsupermarket;

/**
 * This class represents the product.
 * It models the name of the product and price
 * @author Rashpal
 *
 */
public class Item {

	private String name;
    private double price;
    
    public Item() {	
    }
    
    public Item(final String name, final double price) {
    	this.name = name;
    	this.price = price;
    }
    
    /**
     * Gets the name of Item
     * @return
     */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the price of Item
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}
    
    
}
