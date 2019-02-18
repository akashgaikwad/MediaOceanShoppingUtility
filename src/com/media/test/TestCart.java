package com.media.test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.media.enumtype.Category;
import com.media.exception.CartNullException;
import com.media.model.Product;
import com.media.util.Cart;

/**
 * <p> This is {@code TestCart } is test class written to test the functionality of {@code Cart} class
 * @author Akash Gaikwad
 *
 */
public class TestCart {
	
	Cart cart = null;
	List<Product> productList = null;
	
	@Before
	public void setUp(){
	 cart = new Cart();
	 productList = new ArrayList<>();
	}

	@Test(expected=CartNullException.class)
	public void testGetTotalBillNullCheck() throws CartNullException{
		productList = null;
		cart.getTotalBill(productList);
	}
	
	@Test
	public void testGetTotalBillEmptyCheck() throws CartNullException{
		assertEquals(0.0, cart.getTotalBill(productList), 0);
	}
	
	@Test
	public void testGetTotalBillSingleProductCheck() throws CartNullException{
		Product p1 = new Product("product1", 1, 100.32, Category.A);
		productList.add(p1);
		assertEquals(110.35, cart.getTotalBill(productList), 0);
	}
	
	@Test
	public void testGetTotalBillDuplicateProductCheck() throws CartNullException{
		Product p1 = new Product("product1", 1, 100.32, Category.A);
		productList.add(p1);
		productList.add(p1);
		assertEquals(220.70, cart.getTotalBill(productList), 0);
	}
	
	@Test
	public void testRoundOfTwoDecimal() throws CartNullException{
		assertEquals(33.46, cart.roundOfTwoDecimal(33.456789),0);
	}
	
	@Test
	public void testRoundOfTwoDecimal2() throws CartNullException{
		assertEquals(1453.12, cart.roundOfTwoDecimal(1453.1236789),0);
	}
	
}
