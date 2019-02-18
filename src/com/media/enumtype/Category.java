package com.media.enumtype;

/**
 * <p> This {@code Category} denotes the enum type A, B, C
 * 	   which represent the Tax Brackets as 10,20 and 0 respectively.
 * @author Akash Gaikwad
 *
 */
public enum Category {
	
		A(10), B(20), C;
		int tax;
		
		private Category() {
		}
		
		private Category(int tax) {
			this.tax = tax;
		}
		
		public int getTax() {
			return this.tax;
		}
}
