package com.media.mainclass;

import java.util.Arrays;
import java.util.List;

import com.media.enumtype.Category;
import com.media.exception.CartNullException;
import com.media.model.Product;
import com.media.util.Cart;

/**
 * <p> This {@code MainClass} class is runner class used 
 *     to run the Utility.
 * 
 * @author Akash Gaikwad
 *
 */
public class MainClass {

	public static void main(String[] args) {
		
		Cart cart = new Cart();
		List<Product> productsSelected = null;
		List<Product> menu = Arrays.asList( 
			new Product("product1", 1, 100.32, Category.A),
			new Product("product2", 2, 1000.45, Category.B),
			new Product("product3", 3, 65000, Category.A),
			new Product("product4", 4, 650, Category.C),
			new Product("product5", 5, 150.32, Category.A),
			new Product("product6", 6, 10.45, Category.B),
			new Product("product7", 7, 65000, Category.A),
			new Product("product8", 8, 650, Category.C),
			new Product("product9", 9, 700.32, Category.A),
			new Product("product10", 10, 800.45, Category.B),
			new Product("product11", 11, 995, Category.A),
			new Product("product12", 12, 410, Category.C)
			);
		
		
		try {
			//product Selection 
			productsSelected = cart.selectProducts(menu);
			//Bill Calculation
			cart.getTotalBill(productsSelected);
		} catch (CartNullException ex) {
			ex.printStackTrace();
		}
		
	}
}
