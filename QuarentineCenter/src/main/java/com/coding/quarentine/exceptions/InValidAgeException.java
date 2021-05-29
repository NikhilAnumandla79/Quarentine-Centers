package com.coding.quarentine.exceptions;

public class InValidAgeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InValidAgeException() {
	    super();
	  }
	  public InValidAgeException(String message, Throwable cause, boolean enableSuppression,
	      boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);
	  }
	  public InValidAgeException(String message, Throwable cause) {
	    super(message, cause);
	  }
	  public InValidAgeException(String message) {
	    super(message);
	  }
	  public InValidAgeException(Throwable cause) {
	    super(cause);
	  }
}
