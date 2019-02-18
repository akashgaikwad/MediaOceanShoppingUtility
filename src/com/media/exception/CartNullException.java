package com.media.exception;

/**
 * <p> This {@code CartNullException} class represents an exception which is thrown when 
 * 	  cart is null.
 * @author Akash Gaikwad
 *
 */
public class CartNullException extends Exception {

	/**
	 * Serial version UID for class
	 */
	private static final long serialVersionUID = 1L;
	String message; 
	
	public CartNullException(String message) {
		this.message = message;
	}
}
