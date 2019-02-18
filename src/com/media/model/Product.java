package com.media.model;

import com.media.enumtype.Category;

/**
 * <p> This {@code Product} class is POJO class for Product.
 * 
 * @author Akash Gaikwad
 *
 */
public class Product {
	
	private String name;
	private int id;
	private int quantity;
	private double price;
	private Category taxCategory;
	
	
	public Product() {
		
	}
	public Product(String name, int id, double price, Category taxCategory) {
		
		this.name = name;
		this.id = id;
		this.price = price;
		this.taxCategory = taxCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getTaxCategory() {
		return taxCategory;
	}
	public void setTaxCategory(Category taxCategory) {
		this.taxCategory = taxCategory;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		
		int hash = 3;
		hash = 53 * hash + (this.name!=null?this.name.hashCode():0);
		hash = 53 * hash + this.getId();
		hash = (int) (53 * hash + this.getPrice());
		hash = 53 * hash + (this.taxCategory!=null?this.getTaxCategory().hashCode():0);
		
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null)
			return false;
		
		if(!Product.class.isAssignableFrom(obj.getClass()))
			return false;
		
		final Product product = (Product) obj;
		
		if((this.name==null)?(product.getName()!=null):(!this.name.equals(product.getName())))
			return false;
		if(this.getId()!=product.getId())
			return false;
		if(this.getPrice()!=product.getPrice())
			return false;
		if((this.getTaxCategory()==null)?(product.getTaxCategory()!=null):(!this.getTaxCategory().equals(product.getTaxCategory())))
			return false;
		
		return true;
	}
	
	
	@Override
	public String toString() {
		return this.id+"\t\t"+this.getName()+"\t\t"+this.getPrice();
	}
}
