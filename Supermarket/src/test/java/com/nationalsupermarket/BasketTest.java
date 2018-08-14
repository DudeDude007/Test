package com.nationalsupermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nationalsupermarket.exception.ItemDoesNotExistException;

public class BasketTest {

	private Basket currentBasket;
	
	@Before
	public void setUp() throws Exception {
		currentBasket = new Basket();
		
		// prepare stock items for the supermarket
		Item apple = new Item("Apple", 0.20);
		Item orange = new Item("Orange", 0.50);
		Item watermelon = new Item("Watermelon", 0.80);
		
		currentBasket.getStock().addItem(apple);
		currentBasket.getStock().addItem(orange);
		currentBasket.getStock().addItem(watermelon);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDisplayBasket() {
		fail("Not yet implemented");
	}

	/**
	 * Test for the example given
	 * @throws Exception
	 */
	@Test
	public void testGetTotalValid() throws Exception{
		currentBasket.addItem("Apple");
		currentBasket.addItem("Apple");
		currentBasket.addItem("Apple");
		currentBasket.addItem("Apple");
		currentBasket.addItem("Orange");
		currentBasket.addItem("Orange");
		currentBasket.addItem("Orange");
		currentBasket.addItem("Watermelon");
		currentBasket.addItem("Watermelon");
		currentBasket.addItem("Watermelon");
		currentBasket.addItem("Watermelon");
		currentBasket.addItem("Watermelon");
		
		assertEquals(currentBasket.getTotal(), 5.1d, 0.001);
	}

	/**
	 * Test for a simple case
	 * @throws Exception
	 */
	@Test
	public void testGetTotalValid1() throws Exception{
		currentBasket.addItem("Apple");
		currentBasket.addItem("Orange");
		currentBasket.addItem("Watermelon");
		
		assertEquals(currentBasket.getTotal(), 1.5d, 0.001);
	}
	
	@Test
	public void testEmptyBasket() throws Exception{
		assertEquals(currentBasket.getTotal(), 0.0d, 0.001);
	}
	
	@Test
	public void testEmptyStock() throws Exception{
		currentBasket = new Basket();
		assertEquals(currentBasket.getTotal(), 0.0d, 0.001);
	}
	
	/** 
	 * Test for when item that is not currently in stock
	 * @throws Exception
	 */
	@Test(expected = ItemDoesNotExistException.class)
	public void testaddInvalidItem() throws Exception {
		currentBasket.addItem("Grape");
	}
		
}
