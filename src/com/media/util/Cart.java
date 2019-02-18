package com.media.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.media.exception.CartNullException;
import com.media.model.Product;
import com.media.util.MetaConstant;

/**
 * <p>
 * This {@code Cart} class is used to calculate the billing amount.
 * <p>
 * 
 * @author Akash Gaikwad
 *
 */
public class Cart {

	public List<Product> list = new ArrayList<>();

	/**
	 * <p>
	 * This method iterates over all the products added into cart by customer.
	 * Calculates: 1.totalCostWithTax = Total billing amount including sales tax.
	 * 2.totalCostWithoutTax = Total billing amount. 3.totalSalesTax = Sales Tax
	 * Amount.
	 * 
	 * Also prints the details of individual products such as basic price, quantity,
	 * taxed amount etc.
	 * </p>
	 * 
	 * @param Cart : Contains list of all products selected by customer.
	 * @return : Returns the total bill including the sales tax.
	 * @throws CartNullException
	 */
	public double getTotalBill(List<Product> cart) throws CartNullException {

		int taxBracket = 0;
		double basePrice = 0;
		double priceWithTax = 0;
		double priceWithoutTax = 0;
		double salesTax = 0;
		double totalCostWithTax = 0;
		double totalSalesTax = 0;
		double totalCostWithoutTax = 0;
		int quantity = 0;

		
		if (cart != null) {
			// Eliminating duplicates
			list.addAll(removeDuplicate(cart));
			
			System.out.println("Id\t" + "name\t" + "Quantity\t" + "Baseprice\t" + "PriceWithoutTax\t" + "SalesTax\t"
					+ "PriceWithTax");
			System.out.println(
					"-----------------------------------------------------------------------------------------");

			// processing individual products for calculation of bill and sales taxes.
			for (Product tempProduct : list) {
				taxBracket = tempProduct.getTaxCategory().getTax();
				basePrice = tempProduct.getPrice();
				quantity = tempProduct.getQuantity();
				
				salesTax = ((double) taxBracket / MetaConstant.HUNDRED_INTEGER) * basePrice * quantity;
				salesTax = roundOfTwoDecimal(salesTax);
				
				priceWithoutTax = basePrice * quantity;
				priceWithoutTax = roundOfTwoDecimal(priceWithoutTax);
				
				priceWithTax = priceWithoutTax + salesTax;
				priceWithTax = roundOfTwoDecimal(priceWithTax);
				
				System.out.println(tempProduct.getId() + "\t" + tempProduct.getName() + "\t" + tempProduct.getQuantity()
						+ "\t" + basePrice + "\t\t"+priceWithoutTax + "\t\t"+ salesTax + "\t\t" + priceWithTax);

				totalCostWithTax = totalCostWithTax + priceWithTax;
				totalCostWithTax = roundOfTwoDecimal(totalCostWithTax);
				
				totalCostWithoutTax = totalCostWithoutTax + priceWithoutTax;
				totalCostWithoutTax = roundOfTwoDecimal(totalCostWithoutTax);
				
				totalSalesTax = totalSalesTax + salesTax;
				totalSalesTax = roundOfTwoDecimal(totalSalesTax);
			}

			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.println("totalCostWithoutTax:\t" + totalCostWithoutTax);
			System.out.println("TotalSalesTax:\t" + totalSalesTax);
			System.out.println("totalCostWithTax:\t" + totalCostWithTax);
		} else {
			throw new CartNullException("Cart is Empty");
		}
		return totalCostWithTax;
	}

	/**
	 * <P>
	 * This method eliminates the duplicate products and instead increase the
	 * quantity. e.g. if product1 was added twice in cart by user. Then this method
	 * will modify the cart to have only product1 with quantity equal to two.
	 * </p>
	 * 
	 * @param cart
	 * @return
	 */
	public Set<Product> removeDuplicate(List<Product> cart) {
		// If same product is selected multiple times it;s quantity should be increased.
		Set<Product> set = new HashSet<>();
		for (Product product : cart) {
			if (set.contains(product))
				product.setQuantity(product.getQuantity() + 1);
			else {
				product.setQuantity(product.getQuantity() + 1);
				set.add(product);
			}
		}
		return set;
	}

	/**
	 * <p> This method 
	 * 		1.Displays Menu to user 
	 * 		2.Inputs choices from user and adds into cart.
	 * </p>
	 * @param menu
	 * @return : List of products entered by user.
	 * @throws IncorrectChoiceException
	 */
	public List<Product> selectProducts(List<Product> menu){
		List<Product> productsSelected = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		// Displaying available Items
		System.out.println("Id\t\t" + "name\t\t\t" + "Baseprice\t");
		System.out.println("--------------------------------------------------------");
		for (Product product : menu) {
			System.out.println(product);
		}
		System.out.println("--------------------------------------------------------");

		// Taking choice from user
		System.out.println("Please enter the id of product to add to cart");
		while (true) {
			System.out.println("Enter 0 to exit");
			int choice = scanner.nextInt();
			Product product = null;
			if (choice == 0)
				break;
			else if((choice > MetaConstant.ZERO_INTEGER && choice<=menu.size())) {
				product = menu.get(choice - 1);
				productsSelected.add(product);
			}else {
				System.out.println("Wrong Input. Please enter Correct id of product to add to cart");
			}
		}
		scanner.close();
		return productsSelected;
	}
	
	/**<p> This method rounds off the input value two decimal places
	 * 		e.g. input = 33.456789 output=33.46
	 * 			 input = 1453.1236789 output=1453.12
	 * @param value
	 * @return Value rounded off two decimal places.
	 */
	public double roundOfTwoDecimal(double value) {
		return new BigDecimal(value).setScale(MetaConstant.TWO_INTEGER, RoundingMode.HALF_UP).doubleValue();
	}

}