package net.ash.shopping.exception;

public class CategoryNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public CategoryNotFoundException(String msg) {
		this.msg = System.currentTimeMillis() +":"+ msg;
	}
	
	public CategoryNotFoundException() {
		this("Category Device not Available");
	}

	public String getMsg() {
		return msg;
	}
	
	
	
	
	
}
