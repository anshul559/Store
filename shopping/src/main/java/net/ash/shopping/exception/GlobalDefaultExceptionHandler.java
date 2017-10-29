package net.ash.shopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Page is not constructed");
		mv.addObject("errorDescription", "This page is not available now");
		mv.addObject("title", "404-Error");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerNoProductFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not Available");
		mv.addObject("errorDescription", "This product is not available right now");
		mv.addObject("title", "Product Unavailable");
		return mv;
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ModelAndView handlerNoCategoryFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Device not Available");
		mv.addObject("errorDescription", "This Category type Device is not available right now");
		mv.addObject("title", "Device Unavailable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerUnknownFoundException(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact Your Administrator");
//		Only for debugging Purpose not Production
		e.printStackTrace(pw);
		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title", "Error");
		return mv;
	}
}
